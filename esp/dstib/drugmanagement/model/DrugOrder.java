package esp.dstib.drugmanagement.model;
import esp.dstib.drugmanagement.model.*;

public class DrugOrder {
    private Order order ;
    private Drug  drug;
    private  int quantity;
    
    public DrugOrder(){}

    public DrugOrder(Drug drug, Order order,int quantity) {
        this.drug = drug;
        this.order = order;
        this.quantity = quantity;
    }
    


    public DrugOrder(int idDrug, int idOrder, int quantity2) {
        
        this.drug = new Drug(idDrug); // Supposons que le constructeur de Drug accepte l'ID comme argument
        this.order = new Order(idOrder); // Supposons que le constructeur de Order accepte l'ID comme argument
        this.quantity = quantity2;
        
    }

    public Order getOrder() {
         return order;
        }

    public void setOrder(Order order){
        this.order = order;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug){
        this.drug = drug;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
