
package codes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBconnection {
    
    
    public static Connection connect(){
        Connection conn=null;
//        jdbc:mysql://localhost:3306/hotel_system?zeroDateTimeBehavior=convertToNull
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_system?autoReconnect=true&useSSL=false","root","");
conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_system?zeroDateTimeBehavior=convertToNull","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
    }
}
