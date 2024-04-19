package esp.dstib.drugmanagement.store;
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;

import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.core.Tools;
import esp.dstib.drugmanagement.model.Client;
import esp.dstib.drugmanagement.model.Drug;

public class ClientStore {
    private final Connection connection;
    
    private String bdName="client";

    public ClientStore() {
        connection = ConnectionDB.getConnection();
    }

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
                    client = new Client(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client select (int id) throws Exception {
        String sql = "SELECT * FROM "+this.bdName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return new Client(id, resultSet.getString("firstName"), resultSet.getString("lastName"));
    }


//    public Client insert (Client client) {
//        String sql = "INSERT INTO " + this.bdName + " (firstName, lastName) VALUES ('"+ client.getFirstName() +"', '"+ client.getLastName() +"') ";
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    client = new Client(id);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return client;
//    }

    public Client insert (Client client) throws Exception {
        String sql = "INSERT INTO "+this.bdName+" (firstName, lastName) VALUES ('"+client.getFirstName()+"', '"+client.getLastName()+"')";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        return new Client(generatedKeys.getInt(1), client.getFirstName(), client.getLastName()  );
    }
}
