/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Prabath
 */
public class DatabaseConnection {
    public static Connection getConnection() {
        
        Connection con = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            //set DB name,username & password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
