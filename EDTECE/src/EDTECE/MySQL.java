/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edtece;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class MySQL {
    
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    public static ResultSet rs2;
    public static ResultSetMetaData rsmd;
    public static String query;
    
    public static void isconnected() throws ClassNotFoundException{
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/edtece_db";
            String username = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    public static ArrayList getStringAndExceptionHandling(String query){
        ArrayList<String> str;
        str = new ArrayList<String>();
        try{
            stmt = MySQL.conn.createStatement();
            rs = MySQL.stmt.executeQuery(query);
            rsmd = rs.getMetaData();
            int nb_colonne = rsmd.getColumnCount();
            
            try{
                while (rs.next()){
                    
                    for (int i = 1; i < nb_colonne + 1; ++i)
                    {
                        str.add(rs.getString(i));
                    }
                    
                }
               
            }
            catch(SQLException e){
            }
        }
        
        catch(SQLException e){
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
        return str;
    }
}
