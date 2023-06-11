/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stefa
 */
public class Penghuni {
    private int id_penghuni;
    private String username, password, nama,alamat,no_telp;

    public Penghuni(int id_penghuni, String username, String password, String nama, String alamat, String no_telp) {
        this.id_penghuni = id_penghuni;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public int getId_penghuni() {
        return id_penghuni;
    }

    public void setId_penghuni(int id_penghuni) {
        this.id_penghuni = id_penghuni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String showPenghuni(){
        return this.username +"|"+ this.password +"|"+ this.nama +"|"+ this.alamat +"|"+ this.no_telp;
    }

    public String toString(){
        return this.nama;
    }
}
