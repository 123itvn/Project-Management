package DAL;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOAN
 */
public class DataAccessHelper {

    protected Connection conn;

    Properties prop = new Properties();
    InputStream input = null;

    public void getConnect() {
        try {
            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            Class.forName(prop.getProperty("driver"));
            String url = "jdbc:sqlserver://" + prop.getProperty("HostName") + ";database=" + prop.getProperty("dbName");
            String user = prop.getProperty("user");
            String pass = prop.getProperty("pass");
            conn = DriverManager.getConnection(url, user , pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getClose() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
