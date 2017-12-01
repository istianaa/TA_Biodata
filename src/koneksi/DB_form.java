package koneksi;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

public class DB_form {
   
    public Connection cc;// koneksi database
    public Statement ss;
    public ResultSet rs;
    
public void Class () throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cc=DriverManager.getConnection("jdbc:mysql://localhost:3307/biodata" ,"root","");
            System.out.println("koneksi ok!!");
            
        }catch (java.lang.ClassNotFoundException e){
            System.err.print("Koneksi dengan Datagase gagal:");
            System.err.println(e.getException());
            
        }
}

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
