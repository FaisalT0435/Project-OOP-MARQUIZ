/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Madluke
 */
public class connect_db {
        public static Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project_oop", "root", "");
            
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection failed"+e.getMessage());
        } 
            return null;
    }
    
}
