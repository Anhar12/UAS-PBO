/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

/**
 *
 * @author ACER
 */
public class Mahasiswa {
    private String Nama, JK, Fakultas, Prodi;
    private double IPK;
    private int NIM;
    
    public Mahasiswa(String nama, int nim, String jk, String fakultas, String prodi, double ipk){
        this.Nama = nama;
        this.NIM = nim;
        this.JK = jk;
        this.Fakultas = fakultas;
        this.Prodi = prodi;
        this.IPK = ipk;
    }
    
    public String getNama(){
        return this.Nama;
    }
    
    public int getNim(){
        return this.NIM;
    }
    
    public String getJK(){
        return this.JK;
    }
    
    public String getFakultas(){
        return this.Fakultas;
    }
    
    public String getProdi(){
        return this.Prodi;
    }
    
    public double getIpk(){
        return this.IPK;
    }
    
}
