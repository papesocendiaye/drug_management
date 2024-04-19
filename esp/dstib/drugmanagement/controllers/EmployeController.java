package esp.dstib.drugmanagement.controllers;
import java.text.ParseException;
import esp.dstib.drugmanagement.core.OrderManagement;
import esp.dstib.drugmanagement.menus.MenuEmploye;
import esp.dstib.drugmanagement.model.Employe;

public class EmployeController {

    private final static MenuEmploye menuEmploye = new MenuEmploye();
    private static OrderManagement orderManagement;
    public static void manage (Employe employe) throws Exception {
        orderManagement = new OrderManagement(employe);
        boolean isLoged = true;
        while (isLoged) {
            
            Integer choice = MenuEmploye.showMainMenu(employe);
            switch (choice) {
                case 1:
                    orderManagement.createOrder();
                    break;
                case 2:
//                    orderManagement.modifyOrder();
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

