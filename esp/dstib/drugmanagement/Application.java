package esp.dstib.drugmanagement;
import esp.dstib.drugmanagement.core.CredentialManagement;

public class Application {
    public static void main (String[] strings) {
        //verification and authentification
        CredentialManagement credentialManagement = new CredentialManagement();
        credentialManagement.verifyEmploye();
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

