package esp.dstib.drugmanagement.menus;

import esp.dstib.drugmanagement.core.Tools;

public class MenuEmploye {

    public static Integer showMainMenu () {
        Tools.print("MENU PRINCIPAL");
        Tools.print("1 - Ajouter une commande");
        Tools.print("2 - Modifier une commande");
        Tools.print("3 - Supprimer une commande");
        Tools.print("4 - Retour");
        return Integer.parseInt( Tools.input(">") ) ;
    }

}
