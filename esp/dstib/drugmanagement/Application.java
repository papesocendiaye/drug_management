package esp.dstib.drugmanagement;


import esp.dstib.drugmanagement.config.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

    public static void main (String[] strings) {
        Connection connection = ConnectionDB.conn();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM medicament");

            while ( resultSet.next() ) {
                String intitule = resultSet.getString(2);
                System.out.println(intitule);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
