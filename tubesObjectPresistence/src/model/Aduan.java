/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nayal
 */
public class Aduan {
    private int id_aduan, id_penghuni;
    private Penghuni penghuni;
    private String deskripsi_aduan, tanggal;

    public Aduan(int id_aduan, int id_penghuni, String tanggal, String deskripsi_aduan) {
        this.id_aduan = id_aduan;
        this.id_penghuni = id_penghuni;
        this.tanggal = tanggal;
        this.deskripsi_aduan = deskripsi_aduan;
    }

    public Aduan(int id, Penghuni penghuni, String tanggal, String deskripsiAduan) {
        this.id_aduan = id;
        this.penghuni = penghuni;
        this.tanggal = tanggal;
        this.deskripsi_aduan = deskripsiAduan;
    }

    public int getId_aduan() {
        return id_aduan;
    }

    public void setId_aduan(int id_aduan) {
        this.id_aduan = id_aduan;
    }

    public int getId_penghuni() {
        return id_penghuni;
    }

    public void setId_penghuni(int id_penghuni) {
        this.id_penghuni = id_penghuni;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDeskripsi_aduan() {
        return deskripsi_aduan;
    }

    public void setDeskripsi_aduan(String deskripsi_aduan) {
        this.deskripsi_aduan = deskripsi_aduan;
    }
    
    public Penghuni getPenghuni() {
        return penghuni;
    }

    public void setPenghuni(Penghuni penghuni) {
        this.penghuni = penghuni;
    }

}
