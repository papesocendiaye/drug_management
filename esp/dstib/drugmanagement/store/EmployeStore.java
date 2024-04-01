package esp.dstib.drugmanagement.store;
import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.model.Employe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeStore {

    private final String bdName = "employe";
    private final Connection connection;
    public EmployeStore () {
        this.connection = ConnectionDB.getConnection();
    }

    public List<Employe> selectAll () throws Exception {
        String sql="SELECT id, firstname, lastname FROM "+this.bdName;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Employe> employes = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            Employe employe = new Employe(id, firstName, lastName);
            employes.add(employe);
        }
        return employes;
    }

    public Employe select (int id) throws Exception {
        String sql = "SELECT * FROM "+this.bdName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String firstName = resultSet.getString("firstname");
        String lastName = resultSet.getString("lastname");
        return new Employe(id, firstName, lastName);
    }

    public List<Employe> selectByKey (String key, String value) throws Exception {
        String sql = "SELECT * FROM "+this.bdName+" WHERE "+key+" like '"+value+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Employe> employes = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            Employe employe = new Employe(id, firstName, lastName);
            employes.add(employe);
        }
        return employes;
    }


    public void delete (int id) throws Exception {
        String sql = "DELETE FROM "+this.bdName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public Employe insert (Employe employe) throws Exception {
        String sql = "INSERT INTO "+this.bdName+" (firstname, lastname) VALUES ('"+employe.getPrenom()+"', '"+employe.getNom()+"')";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        return new Employe(generatedKeys.getInt(1), employe.getPrenom(), employe.getNom() );
    }

    public Employe update (Employe employe) throws Exception {
        String sql = "UPDATE "+this.bdName+" SET lastname = '"+employe.getNom()+"', firstname = '"+employe.getPrenom()+"' WHERE id = "+employe.getId();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        return employe;
    }

    public  Employe selectByKeys(int id) {
        String sql = "SELECT * FROM " + this.bdName + " WHERE id = ?";
        Employe employe = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    employe = new Employe(id, firstName, lastName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employe;
    }
    public  Employe verifyEmploye (int id) {
        Employe employe = null;
    Scanner scanner = new Scanner(System.in);
       System.out.print("Veuillez saisir l'ID de l'employé : ");
       int employeId = scanner.nextInt();
       
       // l'employe est un manager
       String query = "SELECT type FROM employe WHERE id = ? AND type = 'MANAGER'";
       try (PreparedStatement statement = connection.prepareStatement(query)) {
           statement.setInt(1, employeId);
           ResultSet resultSet = statement.executeQuery();
           if (resultSet.next()) {
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            employe = new Employe(id, firstName, lastName);
        }
           
          
       } catch (SQLException e) {
           e.printStackTrace();
       }scanner.close();
       return employe;
    }
   
}
