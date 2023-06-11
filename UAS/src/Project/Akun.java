/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

/**
 *
 * @author ACER
 */
public class Akun {
    private String Username, Password;
    
    public Akun(String username, String password){
        this.Username = username;
        this.Password = password;
    }
    
    public String getUsername(){
        return this.Username;
    }
    
    public String getPassword(){
        return this.Password;
    }
    
    public void setusername(String username){
        this.Username = username;
    }
    
    public void setPassword(String password){
        this.Password = password;
    }
}
