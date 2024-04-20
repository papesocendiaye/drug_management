package esp.dstib.drugmanagement.controllers;
import esp.dstib.drugmanagement.core.CredentialManagement;
import esp.dstib.drugmanagement.core.DrugManagement;
import esp.dstib.drugmanagement.core.EmployeManagement;
import esp.dstib.drugmanagement.core.Tools;
import esp.dstib.drugmanagement.menus.MenuManager;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Drug;
import esp.dstib.drugmanagement.model.Employe;

public class ManagerController {


    private final static EmployeManagement employeManagement = new EmployeManagement();
    private final static CredentialManagement credencialMangement = new CredentialManagement();
    private final static DrugManagement drugManagement =  new DrugManagement();
    private final static MenuManager menuManager = new MenuManager();

    public static void menu (Employe employe) {
        boolean isLoged = true;
        while (isLoged) {
            int choice= Tools.inputId("appuyer 1 pour la gestion d'employé, ou 2 pour la gestion de medicament");
            int choise;
            switch (choice) {
                case 1:
                     choise= MenuManager.crudEmploye(employe);
                     switch(choise){
                         case 1 :
                             Credencial credencial =credencialMangement.createCredencial();
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


                    break;
                case 2:
                    choise= menuManager.crudMed();
                    switch (choise){
                        case 1:
                            drugManagement.createDrug();
                            break;
                        case 2:
                            drugManagement.removeDrug();
                            break;
                        case 3:
                            isLoged =false;
                            break;
                    }
                    break;  
                case 3:
                    isLoged = false;
                    break;
            }
        }
    } // le reste cest pas bon  le programme  doit verifier quel choix il a fait puis lui afficher le menu la
    //refaire la class app aussi
    public static void manage (Employe employe) {
        boolean isLoged = true;
        while (isLoged) {
            
            Integer choice = MenuManager.crudEmploye(employe);
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
