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
            String name_title =  Toolsdrug.input("Veuillez saisir le nom du médicament    : ");
            Drug drug = new Drug(name_title);
            try {
                return this.drugStore.insert(drug);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //[TODO] insert title, price et stock
    
        public void modifyDrug() {
            String name_title=  Toolsdrug.input("Veuillez saisir le title du médicament    : ");
            try {
                List<Drug> drugs = this.drugStore.selectByKey("Title", name_title);
                Tools.printEmployeList(employes);
                String employeId = Tools.input("Saisissez l'id correspondant: ");
                Employe employe = this.employeStore.select(Integer.parseInt(employeId));
                Tools.printEmploye(employe);
                Tools.print( "1 - Prénom" );
                Tools.print( "2 - Nom" );
                Tools.print( "3 - Les deux " );
                String choice = Tools.input("Choix: ");
                switch (choice) {
                    case "1":
                        String newFirstName = Tools.input("Veuillez saisir le nouveau prénom: ");
                        employe.setPrenom(newFirstName);
                        this.employeStore.update(employe);
                        break;
                    case "2":
                        String newlastName = Tools.input("Veuillez saisir le nouveau nom: ");
                        employe.setNom(newlastName);
                        this.employeStore.update(employe);
                        break;
                    case "3":
                        Tools.print("Demande à SOKHNA GNING ");
                        break;
                }
                Tools.printEmploye(employe);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
}
