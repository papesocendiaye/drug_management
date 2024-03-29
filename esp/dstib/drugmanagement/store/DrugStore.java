package esp.dstib.drugmanagement.store;
import esp.dstib.drugmanagement.config.ConnectionDB;
import esp.dstib.drugmanagement.model.Drug;
import esp.dstib.drugmanagement.model.Employe;

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
            Drug drug = new Drug();
            drug.setTitle( resultSet.getString(2) );
            drug.setPrice( resultSet.getDouble(3) );
            drug.setStock( resultSet.getInt(4) );
            drugs.add(drug);
        }
        return drugs;
    }

    public Drug get (int id) {
        return null;
    }

    public void delete (int id) {
    }




    public Drug modify (int id, Drug drug) {
        return null;
    }

}

