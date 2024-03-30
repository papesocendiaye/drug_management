    package esp.dstib.drugmanagement.core;

    import esp.dstib.drugmanagement.model.Drug;
    import esp.dstib.drugmanagement.store.DrugStore;
    import java.util.List;
    
    
    public class DrugManagement {
        private final DrugStore drugStore;
        public DrugManagement() {
            this.drugStore = new DrugStore();
        }
    
        public Drug createDrug () {
    
            String name_title =  Tools.input("Veuillez saisir le nom du médicament    : ");
            String stock_ =  Tools.input("Donner le stock du médicament    : ");
            int stock_drug = Integer.parseInt(stock_);
            String price_ =  Tools.input("Donner le prix du médicament    : ");
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
    public void removeDrug() {
        String id = Tools.input("Veuillez saisir l'identifiant du medicament  que vous souhaitez supprimer : ");
            int idd =Integer.parseInt(id);
            try{
                drugStore.delete(idd);
                Tools.print(id + " a été supprimé");
            }catch (Exception e){
                Tools.print("Erreur lors de la supression de "+id+".\nCause :"+e.getMessage());
            }
    }
    
}
