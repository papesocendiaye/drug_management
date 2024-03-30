package esp.dstib.drugmanagement.store;
import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.model.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DrugStore {
    private static Connection connection ;
    private String dbName = "drug";
    public DrugStore() {
        connection = ConnectionDB.getConnection();
    }


    public List<Drug> getAll () throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+dbName);
        List<Drug> drugs = new ArrayList<>();
        while (resultSet.next()) {
            
            String name_title = resultSet.getString("title") ;
            Double price_drug = resultSet.getDouble("price") ;
            int stock_drug= resultSet.getInt("stock") ;
            Drug drug = new Drug( name_title, price_drug, stock_drug);
            drugs.add(drug);
        }
        return drugs;
    }
    public Drug insert (Drug drug) throws Exception {
        String sql = "INSERT INTO "+this.dbName+" (title, price, stock) VALUES ('"+drug.getTitle()+"', '"+drug.getPrice()+"', '"+drug.getStock()+"')";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        return new Drug(drug.getTitle(), drug.getPrice() , generatedKeys.getInt(1) );
    }
    public Drug select (int id) throws Exception {
        String sql = "SELECT * FROM "+this.dbName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String name_title = resultSet.getString("title");
        Double price_drug = resultSet.getDouble("price");
        int stock_drug= resultSet.getInt("stock") ;
        return new Drug(id, name_title, price_drug, stock_drug);
    }

    public List<Drug> selectByKey (String key, String value) throws Exception {
        String sql = "SELECT * FROM "+this.dbName+" WHERE "+key+" like '"+value+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Drug> drugs = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name_title = resultSet.getString("title");
            Double price_drug = resultSet.getDouble("price");
            int stock_drug= resultSet.getInt("stock") ;
            Drug drug = new Drug(id, name_title, price_drug, stock_drug);
            drugs.add(drug);
        }
        return drugs;
    }




    public void delete (int id) throws Exception {
        String sql = "DELETE FROM "+this.dbName+" WHERE id = "+id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public Drug update (Drug drug) throws Exception {
            String sql = "UPDATE "+this.dbName+" SET title = '"+drug.getTitle()+"', price = '"+drug.getPrice()+"',stock ='"+drug.getStock()+"' WHERE id = "+drug.getId();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            return drug;

    }
}
