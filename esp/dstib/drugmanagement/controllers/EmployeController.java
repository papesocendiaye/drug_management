package esp.dstib.drugmanagement.controllers;
import java.text.ParseException;
import esp.dstib.drugmanagement.core.OrderManagement;
import esp.dstib.drugmanagement.menus.MenuEmploye;
public class EmployeController {

    private final static MenuEmploye menuEmploye = new MenuEmploye();
    private final static OrderManagement orderManagement = new OrderManagement();
    public static void manage () throws ParseException {
        boolean isLoged = true;
        while (isLoged) {
            
            Integer choice = MenuEmploye.showMainMenu();
            switch (choice) {
                case 1:
                    orderManagement.createOrder();
                    break;
                case 2:
                    orderManagement.modifyOrder();
                    break;
                 case 3:
                    orderManagement.removeOrder();
                    break;   
                case 4:
                    isLoged = false;
                    break;
            }
        }
    }
}

