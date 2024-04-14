package esp.dstib.drugmanagement.core;

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
    public static void main(String[] args) {
        CredentialManagement credentialManagement = new CredentialManagement();
        credentialManagement.verifyEmploye();
        
    }
}