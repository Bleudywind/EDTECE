/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edtece;

import EDTECE.GUI.Login;
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
        MySQL.isconnected();
        
        Login lng = new Login();
    }
    
}
