/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prabath
 */
public class CodeOperations {
    
    //get DB connection
    Connection con = DBConnection.getConnection();
    //prepared statement object to hold the query
    PreparedStatement ps;
    
     //method for display details inside the table
    public void display(JTable table) {
        
        try {
            //initialize query to prepared statement object
            ps = con.prepareStatement("SELECT * FROM codecp");
           
            //execute query and hold the result in the result set object
            ResultSet rs = ps.executeQuery();
            //get table model
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            //an array for display rows in the table
            Object[] row;
            
            //when results founds
            while (rs.next()) {
                //initialize array size with number of rows to display in the table
                row = new Object[6];
                
                //set rows with relevant data
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getInt(6);
                
                //add rows to tha table model
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CodeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   //method for insert data into the DB 
    public void insert(String name,String date,String language,String code,int cp) {
        
            try {
                //initialize query to prepared statement object
                ps = con.prepareStatement("INSERT INTO codecp(name,date,language,code,cp) VALUES(?,?,?,?,?)");
                
                //set the unknown values in the query
                ps.setString(1, name);
                ps.setString(2, date);
                ps.setString(3, language);
                ps.setString(4, code);
                ps.setInt(5, cp);
                
                //display success message when query executes successfully
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Details saved...");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CodeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
     public void delete(int id) {
        
         try {
            //initialize query to prepared statement object
            ps = con.prepareStatement("DELETE FROM codecp WHERE id = ?");
            //set the unknown values in the query
            ps.setInt(1, id);
                   
            //display success message when query executes successfully
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Details Deleted..!");
            }
         } catch (SQLException ex) {
            Logger.getLogger(CodeOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
