package esp.dstib.drugmanagement.core;
import java.util.List;
import esp.dstib.drugmanagement.controllers.EmployeController;
import esp.dstib.drugmanagement.controllers.ManagerController;
import esp.dstib.drugmanagement.enums.EnumTypeEmploye;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Drug;
import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.store.CredencialStore;
import esp.dstib.drugmanagement.store.EmployeStore;

public class CredentialManagement {
    private final CredencialStore credentialStore;
    private final EmployeStore employeStore;

    public CredentialManagement() {
        this.credentialStore = new CredencialStore();
        this.employeStore = new EmployeStore();
    }


    public Employe checkCredentials () throws Exception {
        String login = Tools.input   ("Nom d'utilisateur : ");
        String password = Tools.input("Mot de passe      : ");

        List<Credencial> credencials = this.credentialStore.selectByKey("login", login);
        if ( credencials.size() == 1 ) {
            Credencial credencial = credencials.get(0);
            if ( credencial.getPassword().equals(password)
                    &&
                    credencial.getLogin().equals(login)
            ) {
                List<Employe> employes = this.employeStore.selectByKey("to_id_credential", String.valueOf(credencial.getId()) );
                if ( employes.size() == 1 ) {
                    return employes.get(0);
                }else {
                    throw new Exception("Employe not exist");
                }
            }else {
                throw new Exception("Credencials not match");
            }
        }else {
            throw new Exception("Credencials not match");
        }
    }
   

public void verifyEmploye() throws Exception {

    Employe employe = this.checkCredentials();
    Boolean isEmploye = true;

    EnumTypeEmploye typeEmploye = employe.getTypeEmploye();
    if (typeEmploye == EnumTypeEmploye.MANAGER) {
        isEmploye = false;
    }

    if (isEmploye) {
        EmployeController.manage(employe);
    }else {
        //TODO
        ManagerController.menu(employe);
    }
}

public Credencial createCredencial () {
    String login = Tools.input("Veuillez saisir le login de l'employé : ");
    String password = Tools.input("Veuillez saisir le mot de passe de l'employé : ");
    Credencial credencial = new Credencial(login,password);
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