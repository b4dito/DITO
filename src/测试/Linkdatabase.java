package 测试;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;


public class Linkdatabase 
{
     static private Connection  connection;

    public static Connection getConnection() 
    {
        try
        {
        
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root", "niit1234");
        }
        
        catch(Exception e)
        {
         Logger.getLogger(e.getMessage());  
        }
        return connection;
    } 
}
