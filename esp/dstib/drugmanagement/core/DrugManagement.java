    package esp.dstib.drugmanagement.core;

    import esp.dstib.drugmanagement.model.Drug;
    import esp.dstib.drugmanagement.store.DrugStore;
    
    import java.util.List;
import java.util.Scanner;
    
    public class DrugManagement {
        private final DrugStore drugStore;
        public DrugManagement() {
            this.drugStore = new DrugStore();
        }
    
        public Drug createDrug () {
    
            String name_title =  Toolsdrug.input("Veuillez saisir le nom du médicament    : ");
            String stock_ =  Toolsdrug.input("Donner le stock du médicament    : ");
            int stock_drug = Integer.parseInt(stock_);
            String price_ =  Toolsdrug.input("Donner le prix du médicament    : ");
            Double price_drug = Double.parseDouble(price_);

            Drug drug = new Drug(name_title, price_drug, stock_drug);
            try {
                return this.drugStore.insert(drug);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
        }
    
    
        public void modifyDrug() {
           
             
    }
    
}
