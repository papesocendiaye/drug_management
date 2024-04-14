package esp.dstib.drugmanagement.controllers;
import esp.dstib.drugmanagement.core.CredentialManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.menus.MenuManager;

public class ManagerController {


    private final static EmployeManagement employeManagement = new EmployeManagement();
    private final static CredentialManagement credencial = new CredentialManagement();

    public static void manage () {
        boolean isLoged = true;
        while (isLoged) {
            
            Integer choice = MenuManager.showMainMenu();
            switch (choice) {
                case 1:
                    employeManagement.createEmploye();
                    credencial.createCredencial();
                    break;
                case 2:
                    employeManagement.modifyEmploye();
                    credencial.modifyCredencials();
                    break;
                 case 3:
                    employeManagement.removeEmploye();
                    credencial.removeCredencial();
                    break;   
                case 4:
                    isLoged = false;
                    break;
            }
        }
    }
}
