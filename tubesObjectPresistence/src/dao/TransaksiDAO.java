package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;
import control.PemesananControl;
public class TransaksiDAO {
    private DbConnection dbConnection = new DbConnection();

    private Connection con;
    private PemesananControl pemesananControl = new PemesananControl();

    public void insertTransaksi(Transaksi t){
        con = dbConnection.makeConnection();
        String sql ="INSERT INTO transaksi(id_pemesanan, jenis_pembayaran, total_bayar) "
                + "VALUES ('"+t.getId_pemesanan()+"','"+t.getJenis_pembayaran()+"','"+t.getTotal_bayar()+"')";
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

    public void deleteTransaksi(int id_transaksi){
        con = dbConnection.makeConnection();
        String sql = "DELETE FROM transaksi WHERE id_transaksi='"+id_transaksi+"'";
        System.out.println("Deleting Transaksi....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Transaksi");
            statement.close();
        } catch (Exception e){
            System.out.println("Error deleting Transaksi...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }
    
    public List<Transaksi> showTransaksi(String username){
        List<Transaksi> listTransaksi = new ArrayList<>();
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM transaksi t JOIN pemesanan p ON t.id_pemesanan = p.id_pemesanan JOIN penghuni pe ON p.id_penghuni = pe.id_penghuni WHERE pe.username='"+username+"'";
        System.out.println("Showing Transaksi....");
        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()){
                Transaksi t = new Transaksi(
                        result.getInt("id_transaksi"),
                        pemesananControl.getPemesanan(result.getInt("id_pemesanan")),
                        result.getString("jenis_pembayaran"),
                        result.getInt("total_bayar")
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

    public List<Transaksi> showAllTransaksi(String query){
        List<Transaksi> listTransaksi2 = new ArrayList<>();
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM transaksi t JOIN pemesanan p ON t.id_pemesanan = p.id_pemesanan JOIN penghuni pe ON p.id_penghuni = pe.id_penghuni " +
                "WHERE t.id_transaksi LIKE '%"+query+"%' OR p.id_pemesanan LIKE '%"+query+"%' OR pe.nama LIKE '%"+query+"%' OR t.jenis_pembayaran LIKE '%"+query+"%' OR t.total_bayar LIKE '%"+query+"%'";
        System.out.println("Showing Transaksi....");
        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while(result.next()){
                Transaksi t = new Transaksi(
                  result.getInt("id_transaksi"),
                  pemesananControl.getPemesanan(result.getInt("id_pemesanan")),
                  result.getString("jenis_pembayaran"),
                  result.getInt("total_bayar")
                );
                listTransaksi2.add(t);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error showing Transaksi...");
            throw new RuntimeException(e);
        }
        return listTransaksi2;
    }
    
    public void updateTransaksi(Transaksi t, int id_transaksi){
        con = dbConnection.makeConnection();
        String sql = "UPDATE transaksi SET id_pemesanan='"+t.getId_pemesanan()+"', jenis_pembayaran='"+t.getJenis_pembayaran()+"', total_bayar='"+t.getTotal_bayar()+"' WHERE id_transaksi='"+id_transaksi+"'";
        System.out.println("Updating Transaksi....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Transaksi");
            statement.close();
        } catch (Exception e){
            System.out.println("Error updating Transaksi...");
            System.out.println(e);
        }
    }

}
