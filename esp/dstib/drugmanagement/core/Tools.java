package esp.dstib.drugmanagement.core;

import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.model.Order;
import esp.dstib.drugmanagement.model.Drug;

import java.util.List;
import java.util.Scanner;

public class Tools {
    
    public static String inputLastname(String message1) {
        Tools.print(message1);
        Scanner sc = new Scanner (System.in);
        String lastName = sc.nextLine();
        return lastName;
    }
    public static String inputFirstname(String message2) {
        Tools.print(message2);
        Scanner sc = new Scanner (System.in);
        String firstName = sc.nextLine();
        return firstName;
    }
    public static String input(String message) {
        System.out.print(message);
        Scanner sc = new Scanner (System.in);
        return sc.nextLine();
    }
    public static int inputId(String message) {
        System.out.print(message);
        Scanner sc = new Scanner (System.in);
        return sc.nextInt();
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

    public static void printOrderList(List<Order>  orders) {
        Tools.print("Date\tMontant\tClient\tEmployé\tListe Médicaments");
        for (Order order: orders) {
            Tools.print(order.getDate()+"\t"+order.getAmount()+"\t"+order.getClient()+"\t"+order.getEmployee());
        }
    }

    public static void printOrder(Order order) {
        Tools.print("Commande: :Date "+order.getDate()+" Montant "+order.getAmount()+" Client "+order.getClient()+"Employé"+order.getEmployee() );
    }
    

    

}
