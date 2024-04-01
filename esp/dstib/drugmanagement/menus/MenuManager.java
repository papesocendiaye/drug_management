package esp.dstib.drugmanagement.menus;

import esp.dstib.drugmanagement.core.Tools;

public class MenuManager {

    public static Integer showMainMenu () {
        Tools.print("MENU PRINCIPAL");
        Tools.print("1 - Ajouter un employé");
        Tools.print("2 - Modifier un employé");
        Tools.print("3 - Supprimer un employé");
        Tools.print("4 - Retour");
        return Integer.parseInt( Tools.input(">") ) ;
    }

}
