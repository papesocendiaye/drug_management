package esp.dstib.drugmanagement.model;

import java.sql.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private float amount;
    private Client client;
    private Employe employe;
    private List<DrugOrder> drugOrders;

    public Order() {
    }

    public Order(int id, Date date, float amount, Client client, Employe employee) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.client = client;
        this.employe = employee;
    }

    public Order(int idOrder) { //pour int int int de drugOrder
        this.id = idOrder;
    }

    // Getters and setters
    public int getId() { 
        return id;
        }
    public void setId(int id) { 
        this.id = id;
        }
    public  Date getDate() {
        return date;
        }
    public void setDate(Date date) {  
        this.date = date;
        }
    public float getAmount() { 
        return amount;
        }
    public void setAmount(float amount){
        this.amount=amount;
    }
    public Client getClient(){
        return client;
    }
    public void setClient(Client c){
       client=c;  
    }
    public Employe getEmployee(){
         return employe;
    }
        
}
