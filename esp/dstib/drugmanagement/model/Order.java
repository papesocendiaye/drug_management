package esp.dstib.drugmanagement.model;
import java.sql.Date;

public class Order {
    private int id;
    private Date date;
    private Double montant;
    

    public Order() {
    }
    public Order(int id, Date date, Double montant) {
        this.id = id;
        this.date = date;
        this.montant = montant;
    }

    
    public  int getId(){ 
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }


    

}
