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
                Date date_order = resultSet.getDate("date");
                float amount_order = resultSet.getFloat("amount");
                Client client_order= getClientById(resultSet.getInt("client"));
                Employe employe = getEmployeeById(resultSet.getInt("to_id_employe"));
                Order order = new Order(id, date_order, amount_order, client_order, employe);
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
                    Date date_order = resultSet.getDate("date");
                    float amount_order = resultSet.getFloat("amount");
                    Client client_order = getClientById(resultSet.getInt("client"));
                    Employe employe = getEmployeeById(resultSet.getInt("to_id_employe"));
                    order = new Order(id, date_order, amount_order, client_order, employe);
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

    public Order select (int id) throws Exception {
        String sql = "SELECT * FROM "+this.dbName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        Date date_order = resultSet.getDate("Date");
        float amount_order = resultSet.getFloat("Montant");
        Client client_order= (Client) resultSet.getClob("Client") ;
        Employe employe = getEmployeeById(resultSet.getInt("to_id_employe"));
        return new Order(id, date_order, amount_order, client_order, employe);
    }

    public List<Order> selectByKey (String key, String value) throws Exception {
        String sql = "SELECT * FROM "+this.dbName+" WHERE "+key+" like '"+value+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            Date date_order = resultSet.getDate("Date");
            float amount_order = resultSet.getFloat("Montant");
            Client client_order= (Client) resultSet.getClob("Client") ;
            Employe employe_order = (Employe) resultSet.getClob("Employé");
            //List<String> drugOrders = (List<String>) resultSet.getClob("Liste des médicaments");
            Order order = new Order(id, date_order, amount_order, client_order, employe_order);
            orders.add(order);
        }
        return orders;
    }
    public void delete (int id) throws Exception {
        String sql = "DELETE FROM "+this.dbName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
        
    }

   

