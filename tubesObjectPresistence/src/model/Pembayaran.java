/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nayal
 */
public class Pembayaran {
    private int id_pembayaran;
    private String jenis_pembayaran;

    public Pembayaran(int id_pembayaran, String jenis_pembayaran) {
        this.id_pembayaran = id_pembayaran;
        this.jenis_pembayaran = jenis_pembayaran;
    }

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public String getJenis_pembayaran() {
        return jenis_pembayaran;
    }

    public void setJenis_pembayaran(String jenis_pembayaran) {
        this.jenis_pembayaran = jenis_pembayaran;
    }
    
    
}
