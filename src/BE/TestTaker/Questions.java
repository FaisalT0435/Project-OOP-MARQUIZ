/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.TestTaker;

import connection.connect_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Madluke
 */
public class Questions {
Connection con = null;
PreparedStatement ps = null;
Statement st = null;
ResultSet rs = null;

    private int IdSoal;
    private String Soal, Opsi1, Opsi2, Opsi3, Opsi4, Jawaban;

    public Questions(int IdSoal, String Soal, String Opsi1, String Opsi2, String Opsi3, String Opsi4, String Jawaban) {
        this.IdSoal = IdSoal;
        this.Soal = Soal;
        this.Opsi1 = Opsi1;
        this.Opsi2 = Opsi2;
        this.Opsi3 = Opsi3;
        this.Opsi4 = Opsi4;
        this.Jawaban = Jawaban;
    }
    
    

    public int getIdSoal() {
        return IdSoal;
    }

    public void setIdSoal(int IdSoal) {
        this.IdSoal = IdSoal;
    }

    public String getSoal() {
        return Soal;
    }

    public void setSoal(String Soal) {
        this.Soal = Soal;
    }

    public String getOpsi1() {
        return Opsi1;
    }

    public void setOpsi1(String Opsi1) {
        this.Opsi1 = Opsi1;
    }

    public String getOpsi2() {
        return Opsi2;
    }

    public void setOpsi2(String Opsi2) {
        this.Opsi2 = Opsi2;
    }

    public String getOpsi3() {
        return Opsi3;
    }

    public void setOpsi3(String Opsi3) {
        this.Opsi3 = Opsi3;
    }

    public String getOpsi4() {
        return Opsi4;
    }

    public void setOpsi4(String Opsi4) {
        this.Opsi4 = Opsi4;
    }

    public String getJawaban() {
        return Jawaban;
    }

    public void setJawaban(String Jawaban) {
        this.Jawaban = Jawaban;
    }
    
    public void TambahSoal(){
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
            ps.setInt(1, IdSoal);
            ps.setString(2, Soal);
            ps.setString(3, Opsi1);
            ps.setString(4, Opsi2);
            ps.setString(5, Opsi3);
            ps.setString(6, Opsi4);
            ps.setString(7, Jawaban);
            
            ps.execute();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Soal berhasil ditambahkan!");

        }catch (SQLException e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Terjadi kesalahan!");
            
        }finally{
            try {
                ps.close();
            } catch (SQLException e) {
                
            }
        }
    }
    
    public void EditSoal(){
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("update question set Soal=?,Opsi1=?,Opsi2=?,Opsi3=?,Opsi4=?,Jawaban=? where IdSoal=?");
            ps.setInt(7, IdSoal);
            ps.setString(1, Soal);
            ps.setString(2, Opsi1);
            ps.setString(3, Opsi2);
            ps.setString(4, Opsi3);
            ps.setString(5, Opsi4);
            ps.setString(6, Jawaban);
            
            
            //upadte query
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Berhasil ter update");
            // close and re call the same page
        } catch (SQLException e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Gagal diupdate!");
        }finally{
            try {
                st.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
    
    public void HapusSoal(){
        try {
            Connection con = connect_db.getCon();
            ps = con.prepareStatement("delete from question where IdSoal=?");
            ps.setInt(1, IdSoal);

            //upadte query
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Berhasil dihapus");
            // close and re call the same page
        } catch (SQLException e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Gagal dihapus!");
        }
    }
    
    
    
}
