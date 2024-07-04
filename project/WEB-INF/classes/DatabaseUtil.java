import java.sql.*;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseUtil {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) return conn;
        Properties properties = new Properties();
        try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
