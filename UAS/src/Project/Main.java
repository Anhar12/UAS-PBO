/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Project;

import Database.MyDatabase;
import GUI.Login;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Main {
    static public ArrayList<Akun> dataAkun = new ArrayList<>();
    static public ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static public ArrayList<Mahasiswa> dataSearch = new ArrayList<>();
    
    static public boolean cek_akun(String username, String password){
        for (int i = 0 ; i < dataAkun.size() ; i++){
            if (dataAkun.get(i).getUsername().equalsIgnoreCase(username) && dataAkun.get(i).getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }
    
    static public boolean cek_username(String username){
        for (int i = 0 ; i < dataAkun.size() ; i++){
            if (dataAkun.get(i).getUsername().equalsIgnoreCase(username)){
                return false;
            }
        }
        return true;
    }
    
    static public boolean cek_nim(int nim){
        for (int i = 0 ; i < dataMahasiswa.size() ; i++){
            if (dataMahasiswa.get(i).getNim() == nim){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        MyDatabase.read_akun();
        MyDatabase.read_mahasiswa();
        Login login = new Login();
        login.setVisible(true);
    }
    
}
