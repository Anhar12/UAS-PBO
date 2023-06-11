/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Project.Akun;
import Project.Mahasiswa;
import Project.Main;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class MyDatabase {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB = "jdbc:mysql://localhost:3306/dbmahasiswa";
    
    private static Connection CONN;
    private static Statement statement;
    private static ResultSet result;
    private static PreparedStatement Pstatement;
    
    public static void connection(){
        try{
            Class.forName(JDBC_DRIVER);
            CONN = DriverManager.getConnection(DB, "root", "");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Gagal Konek Ke Database Bossku");
        }
    }
    
    public static void read_akun(){
        connection();
        
        try{            
            statement = (Statement) CONN.createStatement();
            
            result = statement.executeQuery("select * from akun");
            Main.dataAkun.clear();
            
            while (result.next()){
                String username = result.getString("username");
                String password = result.getString("password");
                Akun newAkun = new Akun(username, password);
                Main.dataAkun.add(newAkun);
            }
            
            statement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Read Data Akun");
        }
    }
    
    public static void read_mahasiswa(){
        connection();
        
        try{            
            statement = (Statement) CONN.createStatement();
            
            result = statement.executeQuery("select * from mahasiswa order by nim");
            Main.dataMahasiswa.clear();
            
            while (result.next()){
                int nim = result.getInt("nim");
                String nama = result.getString("nama");
                String jk = result.getString("jk");
                String fakultas = result.getString("fakultas");
                String prodi = result.getString("prodi");
                double ipk = result.getDouble("ipk");
                Mahasiswa newMhs = new Mahasiswa(nama, nim, jk, fakultas, prodi, ipk);
                Main.dataMahasiswa.add(newMhs);
            }
            
            statement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Read Data Mahasiswa");
        }
    }
    
    public static void insert_akun(String username, String password){
        connection();
        
        try{            
            String query = "insert into akun values('"+ username +"', '"+ password +"')";
            Pstatement = (PreparedStatement) CONN.prepareStatement(query);
            Pstatement.executeUpdate();
            Pstatement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Insert Data Akun");
        }
    }
    
    public static void insert_mahasiswa(String nama, String jk, String fakultas, String prodi, int nim, double ipk){
        connection();
        
        try{            
            String query = "insert into mahasiswa values('"+ nim +"', '"+ nama +"', '"+ jk +"', '"+ fakultas +"', '"+ prodi +"', '"+ ipk +"')";
            Pstatement = (PreparedStatement) CONN.prepareStatement(query);
            Pstatement.executeUpdate();
            Pstatement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Insert Data Mahasiswa");
        }
    }
    
    public static void search_mahasiswa(String search){
        connection();
        
        try{            
            statement = (Statement) CONN.createStatement();
            
            result = statement.executeQuery("select * from mahasiswa where nim like '%"+ search +"%' or nama like '%"+ search +"%' or fakultas like '%"+ search +"%' or prodi like '%"+ search +"%' or ipk like '%"+ search +"%' or jk like '%"+ search +"%' order by nim");
            Main.dataSearch.clear();
            
            while (result.next()){
                int nim = result.getInt("nim");
                String nama = result.getString("nama");
                String jk = result.getString("jk");
                String fakultas = result.getString("fakultas");
                String prodi = result.getString("prodi");
                double ipk = result.getDouble("ipk");
                Mahasiswa newMhs = new Mahasiswa(nama, nim, jk, fakultas, prodi, ipk);
                Main.dataSearch.add(newMhs);
            }
            
            statement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Read Data Mahasiswa");
        }
    }
    
    static public void delete_mahasiswa(int nim){
        connection();
        
        try{            
            String query = "delete from mahasiswa where nim = '"+ nim +"'";
            Pstatement = (PreparedStatement) CONN.prepareStatement(query);
            Pstatement.executeUpdate();
            Pstatement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Delete Data Mahasiswa");
        }
    }
    
    static public void update_mahasiswa(int NIM, int nim, String nama, String jk, String fakultas, String prodi, double ipk){
        connection();
        
        try{            
            String query = "update mahasiswa set nim = '"+ nim +"', nama = '"+ nama +"', jk = '"+ jk +"', fakultas = '"+ fakultas +"', prodi = '"+ prodi +"', ipk = '"+ ipk +"' where nim = '"+ NIM +"'";
            Pstatement = (PreparedStatement) CONN.prepareStatement(query);
            Pstatement.executeUpdate();
            Pstatement.close();
            CONN.close();
        } catch (SQLException e){
            System.out.println("Gagal Update Data Mahasiswa");
        }
    }
}
