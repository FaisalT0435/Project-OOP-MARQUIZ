/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.role;

import BE.Admin.AdminHome;
/**
 *
 * @author Madluke
 */
public class Teacher extends User{
    private int IdTeacher;
    private User teacher;
    private String Nama, Username, Password;

    public Teacher(int IdTeacher, User teacher, String Nama, String Username, String Password, String Role) {
        super(Role);
        this.IdTeacher = IdTeacher;
        this.teacher = teacher;
        this.Nama = Nama;
        this.Username = Username;
        this.Password = Password;
    }
    

    public int getIdTeacher() {
        return IdTeacher;
    }

    public void setIdTeacher(int IdTeacher) {
        this.IdTeacher = IdTeacher;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    
    
}
