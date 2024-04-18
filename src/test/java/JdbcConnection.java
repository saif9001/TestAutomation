import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    
  

    

    public static void main(String[]args) throws SQLException, ClassNotFoundException {

            JdbcConnection.getDBConnectionForReadAndWrite();
        }
        
        public static Connection getDBConnectionForReadAndWrite() throws ClassNotFoundException, SQLException {
            Connection dbConnection = null;
//           Class.forName("com.mysql.jdbc.Driver");

            dbConnection = DriverManager.getConnection("jdbc:mysql://192.168.100.94:3306/evi_renovo?autoReconnect=true","autowrite" ,"jA%9Dv$5vh8&");
             System.out.println("Testt");
            return dbConnection;
        }

    }

