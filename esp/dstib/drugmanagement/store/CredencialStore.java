package esp.dstib.drugmanagement.store;
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;
import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.enums.EnumTypeEmploye;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Employe;

public class CredencialStore {
    private final String bdName = "credential";
    private final Connection connection;
    public CredencialStore() {
        this.connection = ConnectionDB.getConnection();
    }
    public Employe selectType(int id) throws Exception {
        Employe employe = null;
    
        // Vérification du type d'employé en fonction de l'ID
        String query = "SELECT type FROM employe  WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                EnumTypeEmploye typeEmploye = EnumTypeEmploye.valueOf(resultSet.getString("type"));
                employe = new Employe(id, typeEmploye);
            }
        }
    
        return employe;
    }
    public Credencial selectCredencial (int id) throws Exception {

        // Vérification du type d'employé en fonction de l'ID
        
        String sql = "SELECT * FROM credential WHERE id = "+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        return new Credencial( login, password);


    }
    public void delete (int id) throws Exception {
        String sql = "DELETE FROM " +this.bdName+ "WHERE id = "+id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public Credencial insert (Credencial credencial) throws Exception {
        String sql = "INSERT INTO "+this.bdName+" (id,login, password) VALUES ('"+credencial.getId()+"','"+credencial.getLogin()+"', '"+credencial.getPassword()+"')";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        return new Credencial(generatedKeys.getInt(1), credencial.getLogin(), credencial.getPassword() );
    }

    public Credencial update (Credencial credencial) throws Exception {
        String sql = "UPDATE "+this.bdName+" SET password = '"+credencial.getPassword()+"', login = '"+credencial.getLogin()+"' WHERE id = "+credencial.getId();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        return credencial;
    }
    public List<Credencial> selectByKey (String key, String value) throws Exception {
        String sql = "SELECT * FROM "+this.bdName+" WHERE "+key+" like '"+value+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Credencial> credencials = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            Credencial credencial = new Credencial(id, login, password);
            credencials.add(credencial);
        }
        return credencials;
    }
    public  Credencial selectByKeys(int id) {
        String sql = "SELECT * FROM " + this.bdName + " WHERE id = ?";
        Credencial credencial = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");
                    credencial = new Credencial(id, login, password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencial;
    }
    public List<Credencial> selectAll () throws Exception {
        String sql="SELECT id, login, password FROM "+ this.bdName;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Credencial> credencials = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            Credencial credencial = new Credencial(id, login, password);
            credencials.add(credencial);
        }
        return credencials;
    }
    public Credencial select (int id) throws Exception {
        String sql = "SELECT * FROM "+this.bdName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        return new Credencial(id, login, password);
    }


    //faut faire le crud de credencial store comme ca a chque fois qu'on ajoute un employe par exemple il faudra 
    //appeller la methode addCredentials pour que l'employé ajouté donne son login et mdp pour plus tard
    //pouvoir se connecter lui aussi .. en faire de meme pour les autres methodes.
}
