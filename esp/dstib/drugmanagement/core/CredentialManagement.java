package esp.dstib.drugmanagement.core;
import java.util.List;
import esp.dstib.drugmanagement.controllers.EmployeController;
import esp.dstib.drugmanagement.controllers.ManagerController;
import esp.dstib.drugmanagement.enums.EnumTypeEmploye;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.store.CredencialStore;

public class CredentialManagement {
    private final CredencialStore credentialStore;

    public CredentialManagement() {
        this.credentialStore = new CredencialStore();
    }
 
   

public void verifyEmploye() {
    int id = Tools.inputId("Veuillez saisir votre ID pour identification : ");
    boolean isEmploye = false;



    try {
        Employe employe = this.credentialStore.selectType(id);
        if (employe != null) {
            EnumTypeEmploye typeEmploye = employe.getTypeEmploye();
            if (typeEmploye == EnumTypeEmploye.MANAGER) {
                System.out.println("Vous êtes un manager.");
            } else {
                System.out.println("Vous êtes un employé.");
                isEmploye = true;
            }

            // Demander le login et le mot de passe
            Tools.print("Connexion ");
            String login = "";
            String password =  "";
             // Vérifier le login et le mot de passe
             boolean mdpCorrect=false;
             while (!mdpCorrect) {
                 login = Tools.input("Nom d'utilisateur : ");
                 password =  Tools.input("Mot de passe      : ");
             Credencial credencial= this.credentialStore.selectCredencial(id);
            if (login.equals(credencial.getLogin()) && password.equals(credencial.getPassword())) {
                System.out.println("Login et mot de passe corrects.");
                mdpCorrect = true;
            } else {
                System.out.println("Login ou mot de passe incorrect.");
            }
        }
        if (isEmploye) {
            EmployeController.manage();
        }else {
            ManagerController.manage();
        }
        } 
        else {
            System.out.println("Employé introuvable.");
        
    }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

public Credencial createCredencial () {
    int id =  Tools.inputId("Veuillez L'id correspondant a l'id de l'employe   : ");
    String login = Tools.input("Veuillez saisir le login de l'employé : ");
    String password = Tools.input("Veuillez saisir le mot de passe de l'employé : ");
    Credencial credencial = new Credencial(id,login,password);
    try {
        return this.credentialStore.insert(credencial);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

public void modifyCredencials() {
    String Login =  Tools.input("Veuillez saisir l'id de l'employé    : ");
    try {
        List<Credencial> credencials = this.credentialStore.selectByKey("Login", Login);
        Tools.printCredencialList(credencials);
        String credencialId = Tools.input("Saisissez l'id correspondant: ");
        Credencial credencial = this.credentialStore.select(Integer.parseInt(credencialId));
        Tools.printCredencial (credencial);
        Tools.print( "1 - login" );
        Tools.print( "2 - password" );
        Tools.print( "3 - Les deux " );
        String choice = Tools.input("Choix: ");
        switch (choice) {
            case "1":
                String newLogin = Tools.input("Veuillez saisir le nouveau login: ");
                credencial.setLogin(newLogin);
                this.credentialStore.update(credencial);
                break;
            case "2":
                String newPassword = Tools.input("Veuillez saisir le nouveau password: ");
                credencial.setPassword(newPassword);
                this.credentialStore.update(credencial);
                break;
            case "3":
                String newLog = Tools.input("Veuillez saisir le nouveau login: ");
                credencial.setLogin(newLog);
                this.credentialStore.update(credencial);
                String newPasswd = Tools.input("Veuillez saisir le nouveau password: ");
                credencial.setPassword(newPasswd);
                this.credentialStore.update(credencial);
                break;
        }
        Tools.printCredencial(credencial);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
public void removeCredencial() {
    String id = Tools.input("Veuillez saisir l'identifiant de l'employé que vous souhaitez supprimer : ");
        int idf =Integer.parseInt(id);
        try{
            credentialStore.delete(idf);
            Tools.print(id + " a été supprimé");
        }catch (Exception e){
            Tools.print("Erreur lors de la supression de "+id+".\nCause :"+e.getMessage());
        }
}



   
}