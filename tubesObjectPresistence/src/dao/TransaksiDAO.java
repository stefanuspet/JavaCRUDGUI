package dao;

import connection.DbConnection;
import control.KamarControl;
import control.PelanggaranControl;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;
import control.PemesananControl;
import control.PenghuniControl;
import model.Pemesanan;
import model.Penghuni;

public class TransaksiDAO {

    private DbConnection dbConnection = new DbConnection();

    private Connection con;
    private PemesananControl pemesananControl = new PemesananControl();

    private KamarControl kc = new KamarControl();
    private PenghuniControl pc = new PenghuniControl();
    private PelanggaranControl plc = new PelanggaranControl();

    public void insertTransaksi(Transaksi t) {
        con = dbConnection.makeConnection();
        String sql = "INSERT INTO transaksi(id_pemesanan, jenis_pembayaran) "
                + "VALUES ('" + t.getId_pemesanan() + "','" + t.getJenis_pembayaran() + "')";
        System.out.println("Adding Transaksi....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Transaksi...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void deleteTransaksi(int id_transaksi) {
        con = dbConnection.makeConnection();
        String sql = "DELETE FROM transaksi WHERE id_transaksi='" + id_transaksi + "'";
        System.out.println("Deleting Transaksi....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Transaksi...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public List<Transaksi> showTransaksiByPenghuni(String id_penghuni, String query) {
        List<Transaksi> listTransaksi = new ArrayList<>();
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM transaksi t JOIN pemesanan p ON t.id_pemesanan = p.id_pemesanan JOIN penghuni pe ON p.id_penghuni = pe.id_penghuni WHERE "
                + "pe.id_penghuni LIKE '%" + id_penghuni + "%' OR t.id_transaksi LIKE '%" + query + "%' OR p.id_pemesanan LIKE '%" + query + "%' OR pe.nama LIKE '%" + query + "%' OR t.jenis_pembayaran LIKE '%" + query + "%'";
        System.out.println("Showing Transaksi....");
        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()) {
                Transaksi t = new Transaksi(
                        result.getInt("id_transaksi"),
                        pemesananControl.getPemesanan(result.getInt("id_pemesanan")),
                        result.getString("jenis_pembayaran")
                );
                listTransaksi.add(t);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error showing Transaksi...");
            throw new RuntimeException(e);
        }
        return listTransaksi;
    }

    public List<Transaksi> showTransakasiByUser(String query, String user) {
        List<Transaksi> listTransaksi2 = new ArrayList<>();
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM transaksi "
                + "JOIN pemesanan ON transaksi.id_pemesanan=pemesanan.id_pemesanan "
                + "JOIN penghuni ON pemesanan.id_penghuni=penghuni.id_penghuni "
                + "WHERE (penghuni.username = '"+user+"') AND "
                + "(transaksi.id_transaksi LIKE '%"+query+"%' "
                + "OR pemesanan.id_pemesanan LIKE '%"+query+"%' "
                + "OR transaksi.jenis_pembayaran LIKE '%"+query+"%')";
        System.out.println("Showing Transaksi....");

        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()) {
                Transaksi t = new Transaksi(
                        result.getInt("id_transaksi"),
                        pemesananControl.getPemesanan(result.getInt("id_pemesanan")),
                        result.getString("jenis_pembayaran")
                );
                listTransaksi2.add(t);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error showing Transaksi...");
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return listTransaksi2;
    }

    public void updateTransaksi(Transaksi t, int id_transaksi) {
        con = dbConnection.makeConnection();
        String sql = "UPDATE transaksi SET id_pemesanan='" + t.getId_pemesanan() + "', jenis_pembayaran='" + t.getJenis_pembayaran() + "' WHERE id_transaksi='" + id_transaksi + "'";
        System.out.println("Updating Transaksi....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Transaksi...");
            System.out.println(e);
        }
    }

    public List<Transaksi> TransaksiAdmin(String query) {
        List<Transaksi> listTransaksi2 = new ArrayList<>();
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM transaksi "
                + "JOIN pemesanan ON transaksi.id_pemesanan=pemesanan.id_pemesanan "
                + "JOIN penghuni ON pemesanan.id_penghuni=penghuni.id_penghuni "
                + "WHERE transaksi.id_transaksi LIKE '%"+query+"%' "
                + "OR pemesanan.id_pemesanan LIKE '%"+query+"%' "
                + "OR transaksi.jenis_pembayaran LIKE '%"+query+"%'";
        System.out.println("Showing Transaksi....");

        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()) {
                Transaksi t = new Transaksi(
                        result.getInt("id_transaksi"),
                        pemesananControl.getPemesanan(result.getInt("id_pemesanan")),
                        result.getString("jenis_pembayaran")
                );
                listTransaksi2.add(t);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error showing Transaksi...");
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return listTransaksi2;
    }

}
