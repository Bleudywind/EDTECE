/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edtece;

import java.sql.SQLException;

/**
 *
 * @author Thomas
 */
public class EDTECE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int i;
       
        
        MySQL.isconnected();
        i = MySQL.getIntAndExceptionHandling("SELECT * FROM utilisateur WHERE ID LIKE 2");
        System.out.print(i);
    }
    
}
