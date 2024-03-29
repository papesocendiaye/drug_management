package esp.dstib.drugmanagement.model;

public class Employe  {
    private int id;
    private String prenom;
    private String nom;

    // Constructeur
    public Employe() {
    }
    public Employe(int id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Employe(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
}

