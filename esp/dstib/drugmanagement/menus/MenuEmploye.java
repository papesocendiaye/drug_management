package esp.dstib.drugmanagement.menus;

import esp.dstib.drugmanagement.core.Tools;
import esp.dstib.drugmanagement.model.Employe;

public class MenuEmploye {


    public static Integer showMainMenu (Employe employe) {
        Tools.print("Bienvenue "+employe.getPrenom()+" "+employe.getNom());
        Tools.print("MENU PRINCIPAL");
        Tools.print("1 - Ajouter une commande");
        Tools.print("2 - Modifier une commande");
        Tools.print("3 - Supprimer une commande");
        Tools.print("4 - quitter");
        return Integer.parseInt( Tools.input(">") ) ;
    }

}
