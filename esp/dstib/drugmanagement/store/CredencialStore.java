package esp.dstib.drugmanagement.store;
import java.sql.* ;
import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.enums.EnumTypeEmploye;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Employe;

public class CredencialStore {
    private final String bdName = "employe";
    private final Connection connection;
    public CredencialStore() {
        this.connection = ConnectionDB.getConnection();
    }
    public Employe selectType(int id) throws Exception {
        Employe employe = null;
    
        // Vérification du type d'employé en fonction de l'ID
        String query = "SELECT type FROM " + this.bdName + " WHERE id = ?";
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
    //faut faire le crud de credencial store comme ca a chque fois qu'on ajoute un employe par exemple il faudra 
    //appeller la methode addCredentials pour que l'employé ajouté donne son login et mdp pour plus tard
    //pouvoir se connecter lui aussi .. en faire de meme pour les autres methodes.
}
