    package BE.Teacher;

import BE.TestTaker.Questions;
import connection.connect_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madluke
 */
public class TeacherHome implements LihatSoal, LihatTestTaker{
Connection con = null;
PreparedStatement pst = null;
Statement st = null;
ResultSet rs = null;

    private int IdTestTaker;
    private String NamaTest, JenisKelaminTest, EmailTest;

    public TeacherHome(int IdTestTaker, String NamaTest, String JenisKelaminTest, String EmailTest) {
        this.IdTestTaker = IdTestTaker;
        this.NamaTest = NamaTest;
        this.JenisKelaminTest = JenisKelaminTest;
        this.EmailTest = EmailTest;
    }

    public int getIdTestTaker() {
        return IdTestTaker;
    }

    public void setIdTestTaker(int IdTestTaker) {
        this.IdTestTaker = IdTestTaker;
    }

    public String getNamaTest() {
        return NamaTest;
    }

    public void setNamaTest(String NamaTest) {
        this.NamaTest = NamaTest;
    }

    public String getJenisKelaminTest() {
        return JenisKelaminTest;
    }

    public void setJenisKelaminTest(String JenisKelaminTest) {
        this.JenisKelaminTest = JenisKelaminTest;
    }

    public String getEmailTest() {
        return EmailTest;
    }

    public void setEmailTest(String EmailTest) {
        this.EmailTest = EmailTest;
    }
    
    public void TambahSoal(Questions soal){
        int IdSoal = soal.getIdSoal();
        
        
    }
    
    public void EditSoal(){
        
    }
    
    public void HapusSoal(){
        
    }
    
    @Override
    public void LihatSoal(JTable tableSoal){
        try {
            con = connect_db.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from question");
            
            DefaultTableModel table = (DefaultTableModel) tableSoal.getModel();
            table.setRowCount(0);
            while(rs.next()){
                Object record[] = {
                    rs.getInt("IdSoal"),
                    rs.getString("Soal"),
                    rs.getString("Opsi1"),
                    rs.getString("Opsi2"),
                    rs.getString("Opsi3"),
                    rs.getString("Opsi4"),
                    rs.getString("Jawaban")
                };
                table.addRow(record);
            }
            
            
        } catch(SQLException e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e.getMessage());
        }
        
        
    }
    
    @Override
    public void LihatTestTaker(JTable tableTT){
        try {
            con = connect_db.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from testtaker");
            
            DefaultTableModel table = (DefaultTableModel) tableTT.getModel();
            table.setRowCount(0);
            while(rs.next()){
                Object record[] = {
                    rs.getInt("IdTestTaker"),
                    rs.getString("Nama"),
                    rs.getString("jenisKelamin"),
                    rs.getString("Email"),
                    rs.getString("Nilai")
                };
                table.addRow(record);
            }
            
            
        } catch(SQLException e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e.getMessage());
        }
    }
    
    
}
