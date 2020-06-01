/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edtece;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class EDTECE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<String> i;
        i = new ArrayList<String>();
       
        
        MySQL.isconnected();
        i = MySQL.getStringAndExceptionHandling("SELECT * FROM `salle` WHERE `ID_SITE` = 1");
        System.out.print(i.get(1));
    }
    
}
