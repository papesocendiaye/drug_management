package esp.dstib.drugmanagement;
import esp.dstib.drugmanagement.core.CredentialManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.core.Tools;

public class Application {
    public static void main (String[] strings) {
        //verification and authentification


        while (true) {

            CredentialManagement credentialManagement = new CredentialManagement();

            try {
                credentialManagement.verifyEmploye();

            } catch (Exception e) {
//                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

        }


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


    }
}

