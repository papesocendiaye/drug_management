package esp.dstib.drugmanagement.core;

import esp.dstib.drugmanagement.model.Employe;

import java.util.List;
import java.util.Scanner;

public class Tools {
    public static String input (String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static void print (String message) {
        System.out.println(message);
    }

    public static void printEmployeList(List<Employe>  employes) {
        Tools.print("ID\tPrénom(s)\tNom");
        for (Employe employe: employes) {
            Tools.print(employe.getId()+"\t"+employe.getPrenom()+"\t"+employe.getNom());
        }
    }

    public static void printEmploye(Employe  employe) {
        Tools.print("Employé: ID: "+employe.getId()+" Prénom(s) "+employe.getPrenom()+" Nom "+employe.getNom() );
    }

}
