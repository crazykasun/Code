/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Prabath
 */
public class Register extends javax.swing.JFrame {

    Connection connection;
    int evtX ;
    int evtY ;
    int x;
    int y;
    
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        connection = db_connection.DatabaseConnection.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        r_password = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ans1 = new javax.swing.JTextField();
        q1 = new javax.swing.JComboBox<String>();
        q2 = new javax.swing.JComboBox<String>();
        ans2 = new javax.swing.JTextField();
        q3 = new javax.swing.JComboBox<String>();
        ans3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        recover_pw = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        pw_txt = new javax.swing.JTextField();
        un_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        reg_btn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1155, 631));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1155, 631));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Your Password : ");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 570, -1, -1));

        r_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        r_password.setForeground(new java.awt.Color(143, 145, 154));
        r_password.setBorder(null);
        r_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r_passwordMouseClicked(evt);
            }
        });
        jPanel1.add(r_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 570, 150, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 29.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, -1, -1));

        ans1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ans1.setForeground(new java.awt.Color(143, 145, 154));
        ans1.setText("  Your Answer...");
        ans1.setBorder(null);
        ans1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans1MouseClicked(evt);
            }
        });
        jPanel1.add(ans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 280, 34));

        q1.setForeground(new java.awt.Color(255, 51, 51));
        q1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your home town?", "What is your first pet's name?", "What is your favourite color?" }));
        jPanel1.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 230, 40));

        q2.setForeground(new java.awt.Color(255, 51, 51));
        q2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your age?", "What is your hair color?", "What is your favourite drink?" }));
        jPanel1.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 230, 40));

        ans2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ans2.setForeground(new java.awt.Color(143, 145, 154));
        ans2.setText("  Your Answer...");
        ans2.setBorder(null);
        ans2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans2MouseClicked(evt);
            }
        });
        jPanel1.add(ans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 280, 34));

        q3.setForeground(new java.awt.Color(255, 51, 51));
        q3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Who is your favourite actor?", "What is your first school?", "What is your favourite band?" }));
        jPanel1.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 230, 40));

        ans3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ans3.setForeground(new java.awt.Color(143, 145, 154));
        ans3.setText("  Your Answer...");
        ans3.setBorder(null);
        ans3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans3MouseClicked(evt);
            }
        });
        jPanel1.add(ans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 280, 34));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 21_1.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, -1, -1));

        recover_pw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 22_1.png"))); // NOI18N
        recover_pw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recover_pw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recover_pwMouseClicked(evt);
            }
        });
        jPanel1.add(recover_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete_20px_1.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 5, 20, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Subtract_20px.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 5, 20, 20));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(143, 145, 154));
        jTextField2.setText("Enter Your Email...");
        jTextField2.setBorder(null);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 365, 190, 30));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(143, 145, 154));
        jTextField4.setText("Re-enter Password...");
        jTextField4.setBorder(null);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 285, 190, 30));

        pw_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pw_txt.setForeground(new java.awt.Color(143, 145, 154));
        pw_txt.setText("Enter Your Password...");
        pw_txt.setBorder(null);
        pw_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pw_txtMouseClicked(evt);
            }
        });
        jPanel1.add(pw_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, 190, 30));

        un_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        un_text.setForeground(new java.awt.Color(143, 145, 154));
        un_text.setText("Enter Your Username...");
        un_text.setBorder(null);
        un_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                un_textMouseClicked(evt);
            }
        });
        jPanel1.add(un_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 125, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 27.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 430, 450));

        reg_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 14.png"))); // NOI18N
        reg_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reg_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reg_btnMouseClicked(evt);
            }
        });
        jPanel1.add(reg_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 410, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Already Registered.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 190, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 15.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 575, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 28.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 550, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/undraw_react_y7wq.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void un_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_un_textMouseClicked
        un_text.setText("");
    }//GEN-LAST:event_un_textMouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void pw_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pw_txtMouseClicked
        pw_txt.setText("");
    }//GEN-LAST:event_pw_txtMouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        jTextField4.setText("");
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       Login login = new Login();
       login.setVisible(true);
       login.pack();
       login.setLocationRelativeTo(null);
       this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        this.setState(1);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void ans1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans1MouseClicked
        ans1.setText("");
    }//GEN-LAST:event_ans1MouseClicked

    private void ans2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans2MouseClicked
        ans2.setText("");
    }//GEN-LAST:event_ans2MouseClicked

    private void ans3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans3MouseClicked
        ans3.setText("");
    }//GEN-LAST:event_ans3MouseClicked

    private void r_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r_passwordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_r_passwordMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Register reg = new Register();
        reg.setVisible(true);
        reg.pack();
        reg.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        evtX = evt.getX();
        evtY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        
        this.setLocation(x-evtX, y-evtY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void reg_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reg_btnMouseClicked
        // TODO add your handling code here:
        String pw = pw_txt.getText().trim();
        String un = un_text.getText().trim();
        String ques1 = q1.getSelectedItem().toString();
        String answer1 = ans1.getText().trim();
        String ques2 = q2.getSelectedItem().toString();
        String answer2 = ans2.getText().trim();
        String ques3 = q3.getSelectedItem().toString();
        String answer3 = ans3.getText().trim();
        
        if(pw.isEmpty() || un.isEmpty() || ques1.isEmpty() || ques2.isEmpty() || ques2.isEmpty() || answer1.isEmpty()|| answer2.isEmpty()|| answer3.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Please fill all feilds!");
        }else{
            String sql = "insert into users values(?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
                ps.setString(1, null);
                ps.setString(2, un);
                ps.setString(3,  pw);
                ps.setString(4, ques1);
                ps.setString(5, answer1);
                ps.setString(6, ques2);
                ps.setString(7, answer2);
                ps.setString(8, ques3);
                ps.setString(9, answer3);
                ps.setInt(10, 3);
                
                ps.executeUpdate();
                
                Login login = new Login();
                login.registeredUserSet(un, pw);
                login.setVisible(rootPaneCheckingEnabled);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_reg_btnMouseClicked

    private void recover_pwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recover_pwMouseClicked
        // TODO add your handling code here:
        String answ1 = ans1.getText().trim();
        String answ2 = ans2.getText().trim();
        String answ3 = ans3.getText().trim();
        
        if(answ1.isEmpty() || answ2.isEmpty() || answ3.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Please fill all answers in order to recover password!");
        }else{
            if(answ1.equals(answer1) && answ2.equals(answer2) && answ3.equals(answer3)){
                try {
                    String sql = "select password from users where user_name = ?";
                    PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
                    ps.setString(1, userName);
                    ResultSet rs = (ResultSet)ps.executeQuery();
                    if(rs.first()){
                        r_password.setText(rs.getString("password"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Answers you provide is not matching with the database!"
                        + "Please contact Admin!");
            }
        }
    }//GEN-LAST:event_recover_pwMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ans1;
    private javax.swing.JTextField ans2;
    private javax.swing.JTextField ans3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField pw_txt;
    private javax.swing.JComboBox<String> q1;
    private javax.swing.JComboBox<String> q2;
    private javax.swing.JComboBox<String> q3;
    private javax.swing.JTextField r_password;
    private javax.swing.JLabel recover_pw;
    private javax.swing.JLabel reg_btn;
    private javax.swing.JTextField un_text;
    // End of variables declaration//GEN-END:variables
    
    private String answer1, answer2, answer3, userName;
    
    public void setSecurityQuestions(String userName, String answer1, String answer2, String answer3, String ques1, String ques2, String ques3){
        q1.setSelectedItem(ques1);
        q2.setSelectedItem(ques2);
        q3.setSelectedItem(ques3);
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.userName = userName;
    }
}
