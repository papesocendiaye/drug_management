package esp.dstib.drugmanagement.core;

import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.model.Drug;

import java.util.List;
import java.util.Scanner;

public class Tools {
    public static String input (String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        in.close();
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

    public static void printDrugList(List<Drug>  drugs) {
        Tools.print("Title\tPrice\tStock");
        for (Drug drug: drugs) {
            Tools.print(drug.getTitle()+"\t"+drug.getPrice()+"\t"+drug.getStock());
        }
    }

    public static void printDrug(Drug drug) {
        Tools.print("Médicaments: Title: "+drug.getTitle()+" Price "+drug.getPrice()+" Stock "+drug.getStock() );
    }
    

}
