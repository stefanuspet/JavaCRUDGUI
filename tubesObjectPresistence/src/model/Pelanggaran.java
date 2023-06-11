/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nayal
 */
public class Pelanggaran {
    private int id_pelanggaran, denda;
    private String jenis_pelanggaran;

    public Pelanggaran(int id_pelanggaran, int denda, String jenis_pelanggaran) {
        this.id_pelanggaran = id_pelanggaran;
        this.denda = denda;
        this.jenis_pelanggaran = jenis_pelanggaran;
    }

    public int getId_pelanggaran() {
        return id_pelanggaran;
    }

    public void setId_pelanggaran(int id_pelanggaran) {
        this.id_pelanggaran = id_pelanggaran;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public String getJenis_pelanggaran() {
        return jenis_pelanggaran;
    }

    public void setJenis_pelanggaran(String jenis_pelanggaran) {
        this.jenis_pelanggaran = jenis_pelanggaran;
    }
    
    public String toString(){
        return jenis_pelanggaran;
    }
    
}
