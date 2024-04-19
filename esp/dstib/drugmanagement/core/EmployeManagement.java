package esp.dstib.drugmanagement.core;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.store.EmployeStore;
import java.util.List;


public class EmployeManagement {
    private final EmployeStore employeStore;
    public EmployeManagement() {
        this.employeStore = new EmployeStore();
    }

    public Employe createEmploye (Credencial credencial) {
        String lastName =  Tools.input("Veuillez saisir le nom de l'employé    : ");
        String firstName = Tools.input("Veuillez saisir le prénom de l'employé : ");
        Employe employe = new Employe(firstName, lastName);
        employe.setCredencial(credencial);
        try {
            return this.employeStore.insert(employe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyEmploye() {
        String firstName =  Tools.input("Veuillez saisir le prenom de l'employé    : ");
        try {
            List<Employe> employes = this.employeStore.selectByKey("firstname", firstName);
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
    public void removeEmploye() {
        String id = Tools.input("Veuillez saisir l'identifiant de l'employé que vous souhaitez supprimer : ");
            int idf =Integer.parseInt(id);
            try{
                employeStore.delete(idf);
                Tools.print(id + " a été supprimé");
            }catch (Exception e){
                Tools.print("Erreur lors de la supression de "+id+".\nCause :"+e.getMessage());
            }
    }


   

}