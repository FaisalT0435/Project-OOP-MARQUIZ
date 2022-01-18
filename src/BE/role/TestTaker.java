/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.role;

import connection.connect_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Madluke
 */
public class TestTaker extends User{
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

    private int IdTestTaker, marks;
    private String Nama, JenisKelamin, Email;

//    public TestTaker(int IdTestTaker, String Nama, String JenisKelamin, String Email, String Role) {
//        super(Role);
//        this.IdTestTaker = IdTestTaker;
//        this.Nama = Nama;
//        this.JenisKelamin = JenisKelamin;
//        this.Email = Email;
//    }
//    
//
//    public int getIdTestTaker() {
//        return IdTestTaker;
//    }
//
//    public void setIdTestTaker(int IdTestTaker) {
//        this.IdTestTaker = IdTestTaker;
//    }
//
//    public String getNama() {
//        return Nama;
//    }
//
//    public void setNama(String Nama) {
//        this.Nama = Nama;
//    }
//
//    public String getJenisKelamin() {
//        return JenisKelamin;
//    }
//
//    public void setJenisKelamin(String JenisKelamin) {
//        this.JenisKelamin = JenisKelamin;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }

    public TestTaker(int IdTestTaker, int marks, String Nama, String JenisKelamin, String Email, String Role) {
        super(Role);
        this.IdTestTaker = IdTestTaker;
        this.marks = marks;
        this.Nama = Nama;
        this.JenisKelamin = JenisKelamin;
        this.Email = Email;
    }

    public int getIdTestTaker() {
        return IdTestTaker;
    }

    public void setIdTestTaker(int IdTestTaker) {
        this.IdTestTaker = IdTestTaker;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(String JenisKelamin) {
        this.JenisKelamin = JenisKelamin;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    
    
    public void SimpanTest(){
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("insert into testtaker values(?,?,?,?,?)");
            ps.setInt(1, IdTestTaker);
            ps.setString(2, Nama);
            ps.setString(3, JenisKelamin);
            ps.setString(4, Email);
            ps.setInt(5, marks );
            
            ps.execute();

        }catch (SQLException e) {
            
        }finally{
            try {
                ps.close();
                
                
            } catch(SQLException e){
                
            }
        }
    }
}
