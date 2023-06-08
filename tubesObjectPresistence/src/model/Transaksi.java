/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nayal
 */
public class Transaksi {
    private int id_transaksi, id_pemesanan;
    private int total_bayar;
    private String jenis_pembayaran;

    private Pemesanan pemesanan;

    public Transaksi(int id_transaksi, int id_pemesanan, String jenis_pembayaran, int total_bayar) {
        this.id_transaksi = id_transaksi;
        this.id_pemesanan = id_pemesanan;
        this.jenis_pembayaran = jenis_pembayaran;
        this.total_bayar = total_bayar;
    }

    public Transaksi(int id_transaksi, Pemesanan pemesanan, String jenis_pembayaran, int total_bayar) {
        this.id_transaksi = id_transaksi;
        this.pemesanan = pemesanan;
        this.jenis_pembayaran = jenis_pembayaran;
        this.total_bayar = total_bayar;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getJenis_pembayaran() {
        return jenis_pembayaran;
    }

    public void setJenis_pembayaran(String jenis_pembayaran) {
        this.jenis_pembayaran = jenis_pembayaran;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }
    
    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }
    
    
}
