/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marquiz.testaker;


import connection.connect_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Madluke
 */
public class QuizPage extends javax.swing.JFrame {
Connection con = null;
PreparedStatement pst = null;
Statement st = null;
ResultSet rs = null;

    public String questionId = "1";
    public String answer;
    public int marks;
    public String idTT;


    /**
     * Creates new form QuizPage
     */
    public QuizPage() {
        initComponents();
        setLocationRelativeTo(null);
        btnSubmit.setVisible(false);
        questions();
    }
    
    // parameterize constructor
    public QuizPage(String id){
        initComponents();
        setLocationRelativeTo(null);
        btnSubmit.setVisible(false);
        questions();
        
        idTT = id;
        
        
    }
    
    public void questions(){
        
        try{
            con = connect_db.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from question WHERE IdSoal='"+questionId+"'");
            
            while(rs.next()){
                String id = rs.getString(1);
                
                String soal = rs.getString(2);
                labelSoal.setText(id+". "+soal);
                
                String opt1 = rs.getString(3);
                radioOpsi1.setText(opt1);
                
                String opt2 = rs.getString(4);
                radioOpsi2.setText(opt2);
                
                String opt3 = rs.getString(5);
                radioOpsi3.setText(opt3);
                
                String opt4 = rs.getString(6);
                radioOpsi4.setText(opt4);
                
                answer = rs.getString(7); 
            }
            
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());           
        }finally{
            try {
                st.close();
                //ps.close();
                rs.close();
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
    
    public void submit() throws SQLException{
        checkAnswer();
        try {
            con = connect_db.getCon();
            st = con.createStatement();
            st.executeUpdate("UPDATE testtaker set Nilai='"+ marks +"' where IdTestTaker ='" + idTT +"'");
//            String marks1 = String.valueOf(marks);
            
            //JOptionPane.showMessageDialog(null, marks1);
            
            setVisible(false);
            new NilaiPage().setVisible(true);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                st.close();
                //ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    public void checkAnswer() throws SQLException{
        String TestTakerAnswer="";
        

        if(radioOpsi1.isSelected()){
            TestTakerAnswer = radioOpsi1.getText();
        }
        else if(radioOpsi2.isSelected()){
            TestTakerAnswer = radioOpsi2.getText();
        }
        else if(radioOpsi3.isSelected()){
            TestTakerAnswer = radioOpsi3.getText();
        }
        else if(radioOpsi3.isSelected()){
            TestTakerAnswer = radioOpsi3.getText();
        }
        
        
        if(TestTakerAnswer.equals(answer)){ 
            marks = marks + 1;
            
        }
            
        //question number change
        int questionId1 = Integer.parseInt(questionId);
        int lastIndex = questionId1 + 1;
        questionId = String.valueOf(lastIndex);

        // clear options
        radioOpsi1.setSelected(false);
        radioOpsi2.setSelected(false);
        radioOpsi3.setSelected(false);
        radioOpsi4.setSelected(false);

        // get last index id
        con = connect_db.getCon();
        st = con.createStatement();
//        rs = st.executeQuery("SELECT COUNT(IdSoal) AS totalID FROM question");
//        
//        int int_last = rs.getInt("totalID");
//        String last = String.valueOf(int_last);
		
	rs = st.executeQuery("SELECT COUNT(*) FROM question");
        while(rs.next()){
            int last = rs.getInt("COUNT(*)");
            // disable next button on last question
            if(questionId.equals(String.valueOf(last))){
                btnNext.setVisible(false);
                btnSubmit.setVisible(true);
            }
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelSoal = new javax.swing.JLabel();
        radioOpsi1 = new javax.swing.JRadioButton();
        radioOpsi2 = new javax.swing.JRadioButton();
        radioOpsi3 = new javax.swing.JRadioButton();
        radioOpsi4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 460));

        jPanel2.setBackground(new java.awt.Color(222, 249, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(50, 100));

        labelSoal.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        labelSoal.setText("1. Default question is ?");

        radioOpsi1.setBackground(new java.awt.Color(222, 249, 255));
        radioOpsi1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        radioOpsi1.setText("jRadioButton1");
        radioOpsi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOpsi1ActionPerformed(evt);
            }
        });

        radioOpsi2.setBackground(new java.awt.Color(222, 249, 255));
        radioOpsi2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        radioOpsi2.setText("jRadioButton2");
        radioOpsi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOpsi2ActionPerformed(evt);
            }
        });

        radioOpsi3.setBackground(new java.awt.Color(222, 249, 255));
        radioOpsi3.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        radioOpsi3.setText("jRadioButton3");
        radioOpsi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOpsi3ActionPerformed(evt);
            }
        });

        radioOpsi4.setBackground(new java.awt.Color(222, 249, 255));
        radioOpsi4.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        radioOpsi4.setText("jRadioButton4");
        radioOpsi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOpsi4ActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioOpsi2)
                                    .addComponent(radioOpsi1)
                                    .addComponent(radioOpsi3)
                                    .addComponent(radioOpsi4)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(494, 494, 494)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(labelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(radioOpsi1)
                .addGap(18, 18, 18)
                .addComponent(radioOpsi2)
                .addGap(18, 18, 18)
                .addComponent(radioOpsi3)
                .addGap(18, 18, 18)
                .addComponent(radioOpsi4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnSubmit))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
    try {
        checkAnswer();
    } catch (SQLException ex) {
        Logger.getLogger(QuizPage.class.getName()).log(Level.SEVERE, null, ex);
    }
        questions();
    }//GEN-LAST:event_btnNextActionPerformed

    private void radioOpsi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOpsi1ActionPerformed
        if(radioOpsi1.isSelected()){
            radioOpsi2.setSelected(false);
            radioOpsi3.setSelected(false);
            radioOpsi4.setSelected(false);
        }
    }//GEN-LAST:event_radioOpsi1ActionPerformed

    private void radioOpsi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOpsi2ActionPerformed
        if(radioOpsi2.isSelected()){
            radioOpsi1.setSelected(false);
            radioOpsi3.setSelected(false);
            radioOpsi4.setSelected(false);
        }
    }//GEN-LAST:event_radioOpsi2ActionPerformed

    private void radioOpsi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOpsi3ActionPerformed
        if(radioOpsi3.isSelected()){
            radioOpsi1.setSelected(false);
            radioOpsi2.setSelected(false);
            radioOpsi4.setSelected(false);
        }
    }//GEN-LAST:event_radioOpsi3ActionPerformed

    private void radioOpsi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOpsi4ActionPerformed
        if(radioOpsi4.isSelected()){
            radioOpsi1.setSelected(false);
            radioOpsi2.setSelected(false);
            radioOpsi3.setSelected(false);
        }
    }//GEN-LAST:event_radioOpsi4ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int response;
        response = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin submit?", "Select", JOptionPane.YES_NO_OPTION);
        if(response == JOptionPane.YES_OPTION){
            try {
                System.out.println(marks);
                System.out.println(idTT);
                checkAnswer();
                submit();
                
                String str_m = String.valueOf(marks);
                NilaiPage page = new NilaiPage(str_m);
                page.setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(QuizPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelSoal;
    private javax.swing.JRadioButton radioOpsi1;
    private javax.swing.JRadioButton radioOpsi2;
    private javax.swing.JRadioButton radioOpsi3;
    private javax.swing.JRadioButton radioOpsi4;
    // End of variables declaration//GEN-END:variables
}
