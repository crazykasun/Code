/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iTEC
 */
public class LineShower extends javax.swing.JFrame {

    /**
     * Creates new form LineShower
     */
    public LineShower() {
        initComponents();
    }
    private List<Integer> levelArr = new ArrayList<>();
    private String code;
    public void takeNestedLevels(ArrayList<Integer> levels){
        levelArr.addAll(levels);
//        System.out.println("Levels : " + levelArr);
        
    }
    
    public int Ctc(String sourceCode){
        
        String allCode = sourceCode; //get code from text field
        int count = 0; //variable to store complexity value
        
        /*
        . - any character except new line
        * - any number of characters
        ? - matches using lowest number of characters
        (.|\n) - any character including new lines
        */
        allCode = allCode.replaceAll("\".*\"", ""); //remove double quotes
        allCode = allCode.replaceAll("\\'.*?\\'", ""); //remove single quotes
        allCode = allCode.replaceAll("//.*?\n", ""); //remove single line comments
        String code = allCode.replaceAll("/\\*(.|\n)*?\\*/", ""); //remove multi-line comments
        
//        System.out.println(code);
        
        //count if conditions, logical and bitwise operators
        CountConditions getIf = new CountConditions(code, "if", 1);
        count = count + getIf.getCount();
        
        //count while
        CountConditions getWhile = new CountConditions(code, "while", 2);
        count = count + getWhile.getCount();
        
        //count for
        CountConditions getFor = new CountConditions(code, "for", 2);
        count = count + getFor.getCountForCatch();
        
        //count catch
        CountConditions getCatch = new CountConditions(code, "catch", 1);
        count = count + getCatch.getCountForCatch();   

        //count case blocks
        Pattern pSwitch = Pattern.compile("case ");
        Matcher mSwitch = pSwitch.matcher(code);
                
        while (mSwitch.find()) {
            ++count; //increment count
        }
 
        return count;
    }
    
    public void tableGenrator(String sourceCode){
        code = sourceCode;
        CodeRefactor codeRefactor = new CodeRefactor();  
        sourceCode = codeRefactor.commentOmmitter(sourceCode);
        sourceCode = codeRefactor.stringOmmitter(sourceCode);
        DefaultTableModel model = (DefaultTableModel)codeTable.getModel();
        String appender = "";
        
        boolean fors = false;
        int forCounter = 0;
        String cncAppender = "";
        boolean cncChecker = false;
        String checkerWhile = "";
        boolean elseIfChecker = false;
        int elseIfCounter = 0;
        int levelCounter = 0;
        int totalCtc = 0;
        int totalCnc = 0;
        
        for(int i = 0; i < sourceCode.length(); i++){
            char position = sourceCode.charAt(i);
            appender = appender + position;
            
            String cncStringChecker = codeRefactor.functionChecker(sourceCode, i);
            
            if(cncStringChecker.contains("for")){
                    fors = true;     
            }
            
            if(cncStringChecker.contains("se if")){
                elseIfChecker = true;
            }
            
            if(elseIfChecker){
                elseIfCounter++;
            }
            
            if(elseIfCounter == 5){
                elseIfChecker = false;
                elseIfCounter = 0;
            }
            
            if((cncStringChecker.contains("for") || cncStringChecker.contains("if") || cncStringChecker.contains("do") ||cncStringChecker.contains("while") || cncStringChecker.contains("switc"))&&(!elseIfChecker)){
//                System.out.println("Conatins : " + cncStringChecker);
                checkerWhile = cncStringChecker;
                cncAppender = "";
                cncChecker = true;
            }
            
            if(cncChecker){               
                cncAppender = cncAppender + position;      
                if(checkerWhile.contains("while")){
                    if(position == '{' || position == ';'){
                        cncChecker = false;
                        checkerWhile = "";
                    }
                }else{
                    if(position == '{'){
                        cncChecker = false;
                    }
                }
            }
            
            if(fors){
                if(position == ';'){
                    forCounter++;
                }else if(position == ':'){
                    forCounter = 2;
                }
            }
            
            if(forCounter == 2){
                    if(position == '{'){                    
                        forCounter = 0;
                        fors = false;
                    }
            }
            if(!fors){
                if(position == '{' || position == '}' || position == ';'){
                    String levelCnc = "0";
                    if(!cncAppender.isEmpty()){
                        try{
                            levelCnc = Integer.toString(levelArr.get(levelCounter));
                            totalCnc = totalCnc + levelArr.get(levelCounter);
                        }catch(IndexOutOfBoundsException e){
                            levelCnc = "0";
                        }
                    }    
                    model.addRow(new Object[]{appender, cncAppender, levelCnc, Ctc(appender)});
                    totalCtc = totalCtc + Ctc(appender);
                    if(!cncAppender.isEmpty()){
                        cncAppender = "";
                        levelCounter++;
                    }
                    appender = "";
                }
            }
            
            ctcTotal.setText(Integer.toString(totalCtc));
            cncTotal.setText(Integer.toString(totalCnc));
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        codeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ctcTotal = new javax.swing.JLabel();
        cncTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        codeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code Line", "Identified Operators", "Cnc", "Ctc"
            }
        ));
        jScrollPane1.setViewportView(codeTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ctc Total");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Cnc Total");

        ctcTotal.setText("jLabel3");

        cncTotal.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(628, 995, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ctcTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(cncTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctcTotal)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cncTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LineShower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LineShower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LineShower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LineShower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LineShower().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cncTotal;
    private javax.swing.JTable codeTable;
    private javax.swing.JLabel ctcTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
