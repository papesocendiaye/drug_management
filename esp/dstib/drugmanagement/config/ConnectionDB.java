package esp.dstib.drugmanagement.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionDB {
    public static Connection getConnection () {

        try {
            Properties properties = new Properties ();
            FileInputStream file = new FileInputStream("esp/dstib/drugmanagement/config/configuration.properties");
            properties.load(file);
            String url = properties.getProperty("jdbc.driver.class");
            Class.forName(url);
            String urlBD = properties.getProperty("jdbc.url");
            String user = properties.getProperty("jdbc.login");
            String password = properties.getProperty("jdbc.password");
            return DriverManager.getConnection (urlBD, user, password);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
