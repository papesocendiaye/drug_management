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
             String name_title =  Tools.input("Veuillez saisir l'intitulé du médicament  : ");
        try {
            List<Drug> drugs = this.drugStore.selectByKey("titre", name_title);
            Tools.printDrugList(drugs);
            String drugId = Tools.input("Saisissez l'id correspondant: ");
            Drug drug = this.drugStore.select(Integer.parseInt(drugId));
            Tools.printDrug(drug);
            Tools.print( "1 - Titre" );
            Tools.print( "2 - Prix" );
            Tools.print( "3 - Stock" );
            Tools.print( "4 - Les trois " );
            String choice = Tools.input("Choix: ");
            switch (choice) {
                case "1":
                    String newName_title = Tools.input("Veuillez saisir le nouveau titre: ");
                    drug.setTitle(newName_title);
                    this.drugStore.update(drug);
                    break;
                case "2":
                    String newPricedrug = Tools.input("Veuillez saisir le nouveau prix: ");
                    Double newPrice_drug = Double.parseDouble(newPricedrug);
                    drug.setPrice(newPrice_drug);
                    this.drugStore.update(drug);
                    break;
                
                case "3":
                    String newStockdrug = Tools.input("Veuillez saisir le nouveau stock: ");
                    Double newStock_drug = Double.parseDouble(newStockdrug);
                    drug.setPrice(newStock_drug);
                    this.drugStore.update(drug);
                    break;
                
                case "4":
                    Tools.print("Demande à SOKHNA GNING ");
                    break;
            }
            Tools.printDrug(drug);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
           
             
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
