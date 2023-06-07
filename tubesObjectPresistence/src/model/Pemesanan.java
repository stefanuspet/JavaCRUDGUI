/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nayal
 */
public class Pemesanan {
    private int id_pemesanan, id_penghuni, id_kamar, id_pelanggaran;
    private String status, tanggal_masuk, tanggal_keluar;

    public Pemesanan(int id_pemesanan, int id_penghuni, int id_kamar, String tanggal_masuk, String tanggal_keluar, int id_pelanggaran,String status) {
        this.id_pemesanan = id_pemesanan;
        this.id_penghuni = id_penghuni;
        this.id_kamar = id_kamar;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_keluar = tanggal_keluar;
        this.id_pelanggaran = id_pelanggaran;
        this.status = status;
    }

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public int getId_penghuni() {
        return id_penghuni;
    }

    public void setId_penghuni(int id_penghuni) {
        this.id_penghuni = id_penghuni;
    }

    public int getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(int id_kamar) {
        this.id_kamar = id_kamar;
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

    public int getId_pelanggaran() {
        return id_pelanggaran;
    }

    public void setId_pelanggaran(int id_pelanggaran) {
        this.id_pelanggaran = id_pelanggaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
