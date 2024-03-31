package esp.dstib.drugmanagement.store;
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;

import esp.dstib.drugmanagement.model.Client;

public class ClientStore {
    private Connection connection; 
    private String bdName="client";

    //  public List<Client> selectByKey(String key, String value) throws Exception {
    //     String sql = "SELECT * FROM "+this.bdName+" WHERE "+key+" like '"+value+"'";
    //     Statement statement = connection.createStatement();
    //     ResultSet resultSet = statement.executeQuery(sql);
    //     List<Client> clients = new ArrayList<>();
    //     while (resultSet.next()) {
    //         int id = resultSet.getInt("id");
    //         Client client = new Client(id);  
    //     }
    //     List<Client> Client;
    //     return clients;
    // }

    public  Client selectByKeys(int id) {
        String sql = "SELECT * FROM " + this.bdName + " WHERE id = ?";
        Client client = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    client = new Client(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
}
