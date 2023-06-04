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
    private int id_pemesanan, id_penghuni, id_kamar, id_pelanggan;
    private int lama_sewa;
    private String status;

    public Pemesanan(int id_pemesanan, int id_penghuni, int id_kamar, int id_pelanggan, int lama_sewa, String status) {
        this.id_pemesanan = id_pemesanan;
        this.id_penghuni = id_penghuni;
        this.id_kamar = id_kamar;
        this.id_pelanggan = id_pelanggan;
        this.lama_sewa = lama_sewa;
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

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public int getLama_sewa() {
        return lama_sewa;
    }

    public void setLama_sewa(int lama_sewa) {
        this.lama_sewa = lama_sewa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
