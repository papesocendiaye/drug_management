package esp.dstib.drugmanagement.store;

import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.model.DrugOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrugOrderStore {
    private static Connection connection;
    private String dbName = "drug_order";

    public DrugOrderStore() {
        connection = ConnectionDB.getConnection();
    }

    public List<DrugOrder> getAll() throws SQLException {
        List<DrugOrder> drugOrders = new ArrayList<>();
        String sql = "SELECT * FROM " + dbName;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int idDrug = resultSet.getInt("to_id_drug");
                int idOrder = resultSet.getInt("to_id_order");
                int quantity = resultSet.getInt("quantity");
                DrugOrder drugOrder = new DrugOrder(idDrug, idOrder, quantity);
                drugOrders.add(drugOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugOrders;
    }

    public void insert(DrugOrder drugOrder) throws SQLException {
        String sql = "INSERT INTO " + dbName + " (to_id_drug, to_id_order, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, drugOrder.getDrug().getId());
            statement.setInt(2, drugOrder.getOrder().getId());
            statement.setInt(3, drugOrder.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idDrug, int idOrder) throws SQLException {
        String sql = "DELETE FROM " + dbName + " WHERE to_id_drug = ? AND to_id_order = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDrug);
            statement.setInt(2, idOrder);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(DrugOrder drugOrder) throws SQLException {
        String sql = "UPDATE " + dbName + " SET quantity = ? WHERE to_id_drug = ? AND to_id_order = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, drugOrder.getQuantity());
            statement.setInt(2, drugOrder.getDrug().getId());
            statement.setInt(3, drugOrder.getOrder().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
