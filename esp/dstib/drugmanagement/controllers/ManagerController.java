package esp.dstib.drugmanagement.controllers;
import esp.dstib.drugmanagement.core.CredentialManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.menus.MenuManager;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Employe;

public class ManagerController {


    private final static EmployeManagement employeManagement = new EmployeManagement();
    private final static CredentialManagement credencialMangement = new CredentialManagement();

    public static void manage (Employe employe) {
        boolean isLoged = true;
        while (isLoged) {
            
            Integer choice = MenuManager.showMainMenu(employe);
            switch (choice) {
                case 1:
                    Credencial credencial = credencialMangement.createCredencial();

                    employeManagement.createEmploye(credencial);
                    break;
                case 2:
                    employeManagement.modifyEmploye();
                    credencialMangement.modifyCredencials();
                    break;
                 case 3:
                    employeManagement.removeEmploye();
                    credencialMangement.removeCredencial();
                    break;   
                case 4:
                    isLoged = false;
                    break;
            }
        }
    }
}
