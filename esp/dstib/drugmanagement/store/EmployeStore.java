package esp.dstib.drugmanagement.store;
import esp.dstib.drugmanagement.model.Employe;

import java.util.List;

public class EmployeStore {

    public List<Employe> getAll () throws RuntimeExeption {
        Connection connection = ConnectionDB.getConnection();
        if (connection == null) { //gerer ca avec exeptions
            System.err.println("La connexion n'est pas initialisée.");
            return 0;
        }
        String sql="SELECT id, prenom, nom FROM employes";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultatSet.next()) {
                int id = resultatSet.getInt("id");
                String prenom = resultatSet.getString("prenom");
                String nom = resultatSet.getString("nom");
                System.out.println("ID: " + id + ", Prénom: " + prenom + ", Nom: " + nom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public Employe get (int id) {

        Connection connection = ConnectionDB.getConnection();
        if (connection == null) { //gerer ca avec exeptions
            System.err.println("La connexion n'est pas initialisée.");
            return 0;
        }
        String sql = "SELECT * FROM employes WHERE id = ?";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultatSet.next()) {
                int id = resultatSet.getInt(1);
                String prenom = resultatSet.getString(2);
                String nom = resultatSet.getString(3);
                System.out.println("ID: " + id + ", Prénom: " + prenom + ", Nom: " + nom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


    public void delete (int id) {
        Connection connection = ConnectionDB.getConnection();
        if (connection == null) { //gerer ca avec exeptions
            System.err.println("La connexion n'est pas initialisée.");
            return 0;
        }
        String sql = "DELETE FROM employes WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql)
            statement.setInt(1, id);
            int suppr = statement.executeUpdate();
            if (suppr > 0) {
                System.out.println("Employé avec l'ID " + id + " supprimé avec succès !");
                return true;
            } else {
                System.out.println("Aucun employé trouvé avec l'ID " + id + ". Aucune suppression n'a été effectuée.");
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void add () throws RuntimeException {
        Connection connection = ConnectionDB.getConnection();
        // Vérifier si la connexion est null
        if (connection == null) { //gerer ca avec exeptions
            System.err.println("La connexion n'est pas initialisée.");
            return 0;
        }
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Veuillez saisir le nom de l'employé : ");
            String nom = scanner.nextLine();
            System.out.println("Veuillez saisir le prenom de l'employé : ");
            String prenom = scanner.nextLine();
            scanner.close();

        }catch(Exception e) { //thow l'exception correspondante
            e.printStackTrace();
        }
        // insertion
        String sql = "INSERT INTO employes (nom, prenom) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.preparedStatement(sql);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.executeUpdate();
            System.out.println("Employé ajouté avec succès !");
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public Employe modify (int id, Employe employe) {

        Connection connection = ConnectionDB.getConnection();
        // Vérifier si la connexion est null
        if (connection == null) { //gerer ca avec exeptions
            System.err.println("La connexion n'est pas initialisée.");
            return 0;
        }
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Veuillez saisir le nom de l'employé : ");

            System.out.println("Veuillez saisir le prenom de l'employé : ");
            employe.setPrenom(scanner.nextLine());
            scanner.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
        // insertion
        String sql = "UPDATE employes SET nom = ?, prenom = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.preparedStatement(sql);
            pstmt.setString(2, employe.getNom());
            pstmt.setString(3, employe.getPrenom());
            pstmt.executeUpdate();
            System.out.println("Employé ajouté avec succès !");
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

}
