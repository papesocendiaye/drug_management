package esp.dstib.drugmanagement.store;
import java.sql.* ;
import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.enums.EnumTypeEmploye;
import esp.dstib.drugmanagement.model.Credencial;
import esp.dstib.drugmanagement.model.Employe;

public class CredentialStore {
    private final String bdName = "credential";
    private final Connection connection;
    public CredentialStore() {
        this.connection = ConnectionDB.getConnection();
    

        public Credencial verifyConnectionEmploye(String  login, String password) {
            String sql="select id from "+this.bdName+"  where  login=? and password=?";
            Statement statement = connection.createStatement();
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                return true;
            }
            else return false;
        }
    }
}