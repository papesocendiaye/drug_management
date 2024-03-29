package esp.dstib.drugmanagement.model;

public class Drug {

    private String title;
    private Double price;
    private int stock;

    public Drug() {
    }
    public Drug(String title, Double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    public Drug( int id, String title, Double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    public Drug(String title){
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
}
