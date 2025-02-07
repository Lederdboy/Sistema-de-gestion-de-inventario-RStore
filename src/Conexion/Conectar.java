package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conectar {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Lederdboy?2005";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_inventarioRStore?useSSL=false&serverTimezone=UTC";
    
    private Connection conn;
    
    public Conectar(){
        conn = null;
    }
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error al cerrar la conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }       
    
}


class prueba{
    public static void main(String[] args) {
        Connection con;
        Conectar conexion = new Conectar();
        con = conexion.getConnection();
    }
}