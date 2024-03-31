package esp.dstib.drugmanagement.store;

import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.model.*;
import esp.dstib.drugmanagement.store.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderStore {
    private static Connection connection;
    private String dbName = "order";

    public OrderStore() {
        connection = ConnectionDB.getConnection();
    }

    public List<Order> getAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM " + dbName;
        
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date date = resultSet.getDate("date");
                float amount = resultSet.getFloat("amount");
                Client client = getClientById(resultSet.getInt("client"));
                Employe employee = getEmployeeById(resultSet.getInt("to_id_employe"));
                Order order = new Order(id, date, amount, client, employee);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return orders;
    }
    public Order get(int id) throws SQLException {
        String sql = "SELECT * FROM " + this.dbName + " WHERE id = ?";
        Order order = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Date date = resultSet.getDate("date");
                    float amount = resultSet.getFloat("amount");
                    Client client = getClientById(resultSet.getInt("client"));
                    Employe employee = getEmployeeById(resultSet.getInt("to_id_employe"));
                    order = new Order(id, date, amount, client, employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public Order insert(Order order) throws SQLException {
        String sql = "INSERT INTO " + this.dbName + " (date, amount, client, to_id_employe) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, order.getDate());
            statement.setFloat(2, order.getAmount());
            statement.setInt(3, order.getClient().getId());
            statement.setInt(4, order.getEmployee().getId());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }


    public Order update(Order order) throws SQLException {
        String sql = "UPDATE " + this.dbName + " SET date = ?, amount = ?, client = ?, to_id_employe = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, order.getDate());
            statement.setFloat(2, order.getAmount());
            statement.setInt(3, order.getClient().getId());
            statement.setInt(4, order.getEmployee().getId());
            statement.setInt(5, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    //cree fonction "tampon" pour vesqui le probleme de static et non-static
    
    private Client getClientById(int clientId) throws SQLException {
        ClientStore clientStore = new ClientStore(); 
        return clientStore.selectByKeys(clientId); 
    }

    private Employe getEmployeeById(int employeeId) throws SQLException {
        EmployeStore employeStore = new EmployeStore(); 
        return employeStore.selectByKeys(employeeId); 
    }

   
}
