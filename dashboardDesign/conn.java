
package dashboardDesign;
import java.sql.*;
import java.sql.Connection;

public class Conn {
    
      Connection c;
      Statement s;
      String url = "jdbc:mysql://127.0.0.1/librarian";
      String username = "root";
      String password = "";
      
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =(Connection) DriverManager.getConnection(url,username,password);    
            s =c.createStatement();  
                               
        }catch(Exception e){ 
            System.out.println(e);         
     
        }      
    }  
}
