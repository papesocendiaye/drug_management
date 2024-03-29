package esp.dstib.drugmanagement.core;

import esp.dstib.drugmanagement.model.Drug;

import java.util.List;
import java.util.Scanner;

public class Toolsdrug {
    public static String input (String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static void print (String message) {
        System.out.println(message);
    }

    public static void printDrugList(List<Drug>  drugs) {
        Tools.print("Title\tPrice\tStock");
        for (Drug drug: drugs) {
            Tools.print(drug.getTitle()+"\t"+drug.getPrice()+"\t"+drug.getStock());
        }
    }

    public static void printDrugList(Drug drug) {
        Tools.print("Médicaments: Title: "+drug.getTitle()+" Price "+drug.getPrice()+" Stock "+drug.getStock() );
    }

}


