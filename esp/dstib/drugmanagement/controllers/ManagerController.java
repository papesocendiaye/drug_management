package esp.dstib.drugmanagement.controllers;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.menus.MenuManager;
public class ManagerController {

    private final static MenuManager menuManager = new MenuManager();
    private final static EmployeManagement employeManagement = new EmployeManagement();
    public static void manage () {
        boolean isLoged = true;
        while (isLoged) {
            //1=> Ajout
            //2=> Modif
            //3=> Suppr
            //4=> Deconnexion
            Integer choice = MenuManager.showMainMenu();
            switch (choice) {
                case 1:
                    employeManagement.createEmploye();
                    break;
                case 4:
                    isLoged = false;
                    break;
            }
        }
    }
}
