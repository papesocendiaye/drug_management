package esp.dstib.drugmanagement.model;

import esp.dstib.drugmanagement.enums.EnumTypeEmploye;

public class Employe  {
    private int id;
    private String prenom;
    private String nom;
    private EnumTypeEmploye typeEmploye;
    private Credencial credencial;

    // Constructeur
    public Employe() {
    }
    public Employe(int id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;

    }

    public Employe(int id){
        this.id=id;
    }
    
    public Employe(int id, String prenom, String nom, EnumTypeEmploye employeType) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.typeEmploye = employeType;

    }
    public Employe (Credencial credencial){
        this.credencial = credencial;
    }
    public Employe (int id , EnumTypeEmploye typeEmploye) {
        this.typeEmploye = typeEmploye;
        this.id = id;
    }

    public Employe(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCredencial(Credencial credencial){
        this.credencial = credencial;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setTypeEmploye(EnumTypeEmploye typeEmploye) {
        this.typeEmploye = typeEmploye;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public EnumTypeEmploye getTypeEmploye() {
        return this.typeEmploye;
    }
}

