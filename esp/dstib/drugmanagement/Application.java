package esp.dstib.drugmanagement;

import esp.dstib.drugmanagement.controllers.EmployeController;
import esp.dstib.drugmanagement.controllers.ManagerController;
import esp.dstib.drugmanagement.core.DrugManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.core.LoginManagement;
import esp.dstib.drugmanagement.core.Tools;
import esp.dstib.drugmanagement.model.Employe;


public class Application {
    
    public static void main (String[] strings) {

        EmployeManagement employeManagement = new EmployeManagement();
        LoginManagement loginManagement = new LoginManagement();

        while (true) {
            boolean logged = false;
            try {
                Employe employe = loginManagement.getLogin();
//                boolean isEmploye = employeManagement.verifyEmploye(employe);
                boolean isEmploye = false;
                if (isEmploye) {
                    EmployeController.manage();
                }else {
                    ManagerController.manage();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }




//        try {
//            Boolean result = employeManagement.verifyEmploye();
//
//            if (result) {
//                Tools.print("C'est un employé");
//            }else {
//                Tools.print("C'est un manager");
//
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//
//                employeManagement.createEmploye();
//                Tools.print("~modifier~" + "\n");
//
//                employeManagement.modifyEmploye();
//                Tools.print("~supprimer~\n");
//
//                employeManagement.removeEmploye();
//
//
//            DrugManagement  drugManagement = new DrugManagement();
//            drugManagement.createDrug();
//             Tools.print("~supprimer~\n");
//
//             drugManagement.removeDrug();
//
       
    }

}
