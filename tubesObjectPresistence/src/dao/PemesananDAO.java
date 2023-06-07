package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pemesanan;

public class PemesananDAO {
    private DbConnection dbConnection = new DbConnection();
    private Connection con;

    public void insertPemesanan(Pemesanan p){
        con = dbConnection.makeConnection();
        String sql ="INSERT INTO pemesanan(id_penghuni, id_kamar, tanggal_masuk, tanggal_keluar, id_pelanggaran, status) "
                + "VALUES ('"+p.getId_penghuni()+"','"+p.getId_kamar()+"','"+p.getTanggal_masuk()+"','"+p.getTanggal_keluar()+"','"+p.getId_pelanggaran()+"','"+p.getStatus()+"')";
        System.out.println("Adding Pemesanan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Pemesanan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Pemesanan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void deletePemesanan(int id_pemesanan){
        con = dbConnection.makeConnection();
        String sql ="DELETE FROM pemesanan WHERE id_pemesanan='"+id_pemesanan+"'";
        System.out.println("Deleting Pemesanan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Pemesanan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Pemesanan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void updatePemesanan(Pemesanan p, int id_pemesanan){
        con = dbConnection.makeConnection();
        String sql ="UPDATE pemesanan SET id_penghuni='"+p.getId_penghuni()+"', id_kamar='"+p.getId_kamar()+"', tanggal_masuk='"+p.getTanggal_masuk()+"', tanggal_keluar='"+p.getTanggal_keluar()+"', id_pelanggaran='"+p.getId_pelanggaran()+"', status='"+p.getStatus()+"' WHERE id_pemesanan='"+id_pemesanan+"'";
        System.out.println("Updating Pemesanan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Pemesanan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Pemesanan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    //kurang select all
}
