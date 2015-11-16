package conexoes;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel
 */
public class ConnectionFactory {
        
    public static Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://","localhost","odontoifma");
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQLException ao abrir a conexão em ConnectionFactory", ex);
        }
    }
    
}
