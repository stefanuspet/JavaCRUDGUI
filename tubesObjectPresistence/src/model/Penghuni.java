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
    private String username, password, nama,alamat,no_telp,tanggal_masuk,tanggal_keluar;

    public Penghuni(int id_penghuni, String username, String password, String nama, String alamat, String no_telp, String tanggal_masuk, String tanggal_keluar) {
        this.id_penghuni = id_penghuni;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_keluar = tanggal_keluar;
    }

    public int getId_penghuni() {
        return id_penghuni;
    }

    public void setId_penghuni(int id_penghuni) {
        this.id_penghuni = id_penghuni;
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

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public String getTanggal_keluar() {
        return tanggal_keluar;
    }

    public void setTanggal_keluar(String tanggal_keluar) {
        this.tanggal_keluar = tanggal_keluar;
    }
    
    
}
