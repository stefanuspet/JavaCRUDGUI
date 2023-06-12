package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pemesanan;
import control.KamarControl;
import control.PenghuniControl;
import control.PelanggaranControl;

public class PemesananDAO {
    private DbConnection dbConnection = new DbConnection();
    private Connection con;

    private KamarControl kc = new KamarControl();
    private PenghuniControl pc = new PenghuniControl();
    private PelanggaranControl plc = new PelanggaranControl();

    public void insertPemesanan(Pemesanan p){
        con = dbConnection.makeConnection();
        String sql = "INSERT INTO pemesanan(id_penghuni, id_kamar, tanggal_masuk, tanggal_keluar, id_pelanggaran, total, status) "
                + "VALUES ('"+p.getId_penghuni()+"','"+p.getId_kamar()+"','"+p.getTanggal_masuk()+"','"+p.getTanggal_keluar()+"','"+p.getId_pelanggaran()+"','"+p.getTotal()+"','"+p.getStatus()+"')";
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
        String sql ="UPDATE pemesanan SET id_penghuni='"+p.getId_penghuni()+"', id_kamar='"+p.getId_kamar()+"', tanggal_masuk='"+p.getTanggal_masuk()+"', tanggal_keluar='"+p.getTanggal_keluar()+"', id_pelanggaran='"+p.getId_pelanggaran()+"', total='"+p.getTotal()+"', status='"+p.getStatus()+"' WHERE id_pemesanan='"+id_pemesanan+"'";
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
     
    public void updateStatus(Pemesanan p, int id_pemesanan){
        con = dbConnection.makeConnection();
        String sql ="UPDATE pemesanan SET status='"+p.getStatus()+"' WHERE id_pemesanan='"+id_pemesanan+"'";
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
    public List<Pemesanan> showAllPemesanan(String query){
        List<Pemesanan> listPemesanan = new ArrayList<>();
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM pemesanan p JOIN penghuni pe ON p.id_penghuni = pe.id_penghuni JOIN " +
                "kamar k ON p.id_kamar = k.id_kamar JOIN pelanggaran pl ON p.id_pelanggaran = pl.id_pelanggaran " +
                "WHERE p.id_pemesanan LIKE '%"+query+"%' OR pe.nama LIKE '%"+query+"%' OR k.nama_kamar LIKE '%"+query+"%' OR p.tanggal_masuk LIKE '%"+query+"%' OR p.tanggal_keluar LIKE '%"+query+"%' OR pl.nama_pelanggaran LIKE '%"+query+"%' OR pl.denda LIKE '%"+query+"%' OR p.total LIKE '%"+query+"%' OR p.status LIKE '%"+query+"%'";

        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()){
                Pemesanan p = new Pemesanan(
                        result.getInt("id_pemesanan"),
                        pc.searchPenghuni(result.getInt("id_penghuni")),
                        kc.getKamar(result.getInt("id_kamar")),
                        result.getString("tanggal_masuk"),
                        result.getString("tanggal_keluar"),
                        plc.getPelanggaran(result.getInt("id_pelanggaran")),
                        result.getInt("total"),
                        result.getString("status")
                );
                listPemesanan.add(p);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error getting Pemesanan...");
            throw new RuntimeException(e);
        }
        return listPemesanan;
    }

    public Pemesanan getPemesanan(int id_pemesanan){
        Pemesanan p = null;
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM pemesanan p JOIN penghuni pe ON p.id_penghuni = pe.id_penghuni JOIN " +
                "kamar k ON p.id_kamar = k.id_kamar JOIN pelanggaran pl ON p.id_pelanggaran = pl.id_pelanggaran " +
                "WHERE p.id_pemesanan = '"+id_pemesanan+"'";

        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()){
                p = new Pemesanan(
                        result.getInt("id_pemesanan"),
                        pc.searchPenghuni(result.getInt("id_penghuni")),
                        kc.getKamar(result.getInt("id_kamar")),
                        result.getString("tanggal_masuk"),
                        result.getString("tanggal_keluar"),
                        plc.getPelanggaran(result.getInt("id_pelanggaran")),
                        result.getInt("total"),
                        result.getString("status")
                );
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error getting Pemesanan...");
            throw new RuntimeException(e);
        }
        return p;
    }
}
