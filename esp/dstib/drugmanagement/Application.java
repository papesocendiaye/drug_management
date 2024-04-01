package esp.dstib.drugmanagement;

import esp.dstib.drugmanagement.core.DrugManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.core.Tools;




public class Application {
    
    public static void main (String[] strings) {

        
       EmployeManagement employeManagement = new EmployeManagement();
       
               
           
                employeManagement.createEmploye();
                Tools.print("~modifier~" + "\n");

                employeManagement.modifyEmploye();
                Tools.print("~supprimer~\n");
                
                employeManagement.removeEmploye();
          
           
            DrugManagement  drugManagement = new DrugManagement();
            drugManagement.createDrug();
             Tools.print("~supprimer~\n");
          
             drugManagement.removeDrug();
          
       
    }

}
