package esp.dstib.drugmanagement.core;

import esp.dstib.drugmanagement.model.Employe;

public class LoginManagement {

    public Employe getLogin () throws Exception {
        Tools.print("Connexion ");
        String login = Tools.input("Nom d'utilisateur : ");
        String password =  Tools.input("Mot de passe      : ");

        //dsqdqsdqsdqsdsqdqsdqsdqsd
        boolean testLogin = true;

        if (testLogin) {
            //recuper employe
            Employe employe = null;
            return employe;
        }else {
            throw new Exception("Employé n'existe pas");
        }
    }

}
