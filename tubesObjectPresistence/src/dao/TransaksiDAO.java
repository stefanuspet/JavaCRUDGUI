package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;
public class TransaksiDAO {
    private DbConnection dbConnection = new DbConnection();

    private Connection con;

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

    //kurang select all

}
