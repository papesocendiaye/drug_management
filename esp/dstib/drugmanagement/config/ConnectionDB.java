package esp.dstib.drugmanagement.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {


    public static Connection conn () {

        try {
            Properties properties = new Properties ();

            try {
                FileInputStream file = new FileInputStream("/workspace/drug-management/esp/dstib/drugmanagement/config/configuration.properties");
                properties.load(file);

            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
            } catch (IOException e) {
//                throw new RuntimeException(e);
                System.out.println("RuntimeException");
            }

            String url = properties.getProperty("jdbc.driver.class");
            Class.forName (url);
            System.out.println ("Le pilote a été bien chargé");
            String urlBD = properties.getProperty("jdbc.url");
            String user = properties.getProperty("jdbc.login");
            String password = properties.getProperty("jdbc.password");
            Connection con = DriverManager.getConnection (urlBD, user, password);
            System.out.println ("Connexion bien établie");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
