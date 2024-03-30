package esp.dstib.drugmanagement;


import esp.dstib.drugmanagement.core.DrugManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.core.Tools;


public class Application {
    public static void main (String[] strings) {
        
       EmployeManagement employeManagement = new EmployeManagement();

        employeManagement.createEmploye();
        //Tools.print("~modifier~" + "\n");
        System.out.println ("Modifier");
        employeManagement.modifyEmploye();
        //Tools.print("~supprimer~\n");
        System.out.println ("Supprimer");
        employeManagement.removeEmploye();
        
        
        
        //drugs test
        
        DrugManagement  drugManagement = new DrugManagement();
        drugManagement.createDrug();
        //Tools.print("~supprimer~\n");
        System.out.println ("Supprimer");
        drugManagement.removeDrug();

       
            


    }



}
