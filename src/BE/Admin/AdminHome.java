/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.Admin;

import connection.connect_db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BE.role.Teacher;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Madluke
 */
public class AdminHome implements LihatTeacher, Pengaturan{
Connection con = null;
Statement st = null;
PreparedStatement ps = null;
ResultSet rs = null;
    
    private int IdT;
    private String NamaT, UsernameT, PassT, SecA, SecQ;

    public AdminHome(int IdT, String NamaT, String UsernameT, String PassT) {
        this.IdT = IdT;
        this.NamaT = NamaT;
        this.UsernameT = UsernameT;
        this.PassT = PassT;
    }

    public int getIdT() {
        return IdT;
    }

    public void setIdT(int IdT) {
        this.IdT = IdT;
    }

    public String getNamaT() {
        return NamaT;
    }

    public void setNamaT(String NamaT) {
        this.NamaT = NamaT;
    }

    public String getUsernameT() {
        return UsernameT;
    }

    public void setUsernameT(String UsernameT) {
        this.UsernameT = UsernameT;
    }

    public String getPassT() {
        return PassT;
    }

    public void setPassT(String PassT) {
        this.PassT = PassT;
    }

    public String getSecA() {
        return SecA;
    }

    public void setSecA(String SecA) {
        this.SecA = SecA;
    }

    public String getSecQ() {
        return SecQ;
    }

    public void setSecQ(String SecQ) {
        this.SecQ = SecQ;
    }
    
    
    
    public void TambahTeacher(){
        
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("insert into teacher values(?,?,?,?)");
            ps.setInt(1, IdT);
            ps.setString(2, NamaT);
            ps.setString(3, UsernameT);
            ps.setString(4, PassT);
            
            
            ps.execute();

        }catch (SQLException e) {
            
        }finally{
            try {
                ps.close();
            } catch (SQLException e) {
                
            }
        }
    }
    
    public void EditTeacher(){
        
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("update teacher set nama=?,Username=?,Password=? where IdTeacher=?");
            ps.setInt(4, IdT);
            ps.setString(1, NamaT);
            ps.setString(2, UsernameT);
            ps.setString(3, PassT);
            
            
            //upadte query
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Berhasil terupdate");
            // close and re call the same page
        } catch (SQLException e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e.getMessage());
        }finally{
            try {
                st.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }
        
    }
    
    public void DeleteTeacher(){
        
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("delete from teacher where IdTeacher=?");
            ps.setInt(1, IdT);

            //upadte query
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Successfully deleted");
            // close and re call the same page
        } catch (SQLException e) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf,"Something went wrong " + e.getMessage());
        }
    }
    
    @Override
    public void LihatTeacher(JTable tableTeacher){

        try {
            con = connect_db.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from teacher");
            
            DefaultTableModel table = (DefaultTableModel) tableTeacher.getModel();
            table.setRowCount(0);
            while(rs.next()){
                Object record[] = {
                    rs.getInt("IdTeacher"),
                    rs.getString("Nama"),
                    rs.getString("Username"),
                    rs.getString("Password")
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
    public void Pengaturan(String secQ, String secA){
        this.SecQ = secQ;
        this.SecA = secA;
       
        try {
            con = connect_db.getCon();
            ps = con.prepareStatement("update admin set Nama=?, Username=?, Password=?, SecQuestion=?, SecAnswer=?");
            ps.setString(1, NamaT);
            ps.setString(2, UsernameT);
            ps.setString(3, PassT);
            ps.setString(4, SecQ);
            ps.setString(5, SecA);
            ps.executeUpdate();
            
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf,"berhasil terudpate");
            
        }catch (SQLException e) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf,"Gagal terudpate" + e.getMessage());
        }
    }
    
    
}
