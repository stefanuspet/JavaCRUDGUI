package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggaran;

public class PelanggaranDAO {
    private DbConnection dbConnection = new DbConnection();

    private Connection con;

    public void insertPelanggaran(Pelanggaran p){
        con = dbConnection.makeConnection();
        String sql ="INSERT INTO pelanggaran(jenis_pelanggaran, denda) "
                + "VALUES ('"+p.getJenis_pelanggaran()+"','"+p.getDenda()+"')";
        System.out.println("Adding Pelanggaran....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Pelanggaran");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Pelanggaran...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void deletePelanggaran(int id_pelanggaran){
        con = dbConnection.makeConnection();
        String sql ="DELETE FROM pelanggaran WHERE id_pelanggaran='"+id_pelanggaran+"'";
        System.out.println("Deleting Pelanggaran....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Pelanggaran");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Pelanggaran...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void updatePelanggaran(Pelanggaran p, int id_pelanggaran){
        con = dbConnection.makeConnection();
        String sql ="UPDATE pelanggaran SET jenis_pelanggaran='"+p.getJenis_pelanggaran()+"', denda='"+p.getDenda()+"' WHERE id_pelanggaran='"+id_pelanggaran+"'";
        System.out.println("Updating Pelanggaran....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Pelanggaran");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Pelanggaran...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public ArrayList<Pelanggaran> showPelanggaran(){
        con = dbConnection.makeConnection();
        ArrayList<Pelanggaran> listPelanggaran = new ArrayList<>();
        String sql = "SELECT * FROM pelanggaran";
        System.out.println("Showing Pelanggaran....");
        try {
            Statement statement = con.createStatement();
            java.sql.ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Pelanggaran p = new Pelanggaran(result.getInt("id_pelanggaran"),  result.getInt("denda"), result.getString("jenis_pelanggaran"));
                listPelanggaran.add(p);
            }
            System.out.println("Show " + listPelanggaran.size() + " Pelanggaran");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error showing Pelanggaran...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
        return listPelanggaran;
    }

    public Pelanggaran getPelanggaran(int id_pelanggaran){
        con = dbConnection.makeConnection();
        Pelanggaran p = null;
        String sql = "SELECT * FROM pelanggaran WHERE id_pelanggaran='"+id_pelanggaran+"'";
        System.out.println("Getting Pelanggaran....");
        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()) {
                p = new Pelanggaran(result.getInt("id_pelanggaran"),  result.getInt("denda"), result.getString("jenis_pelanggaran"));
            }
            System.out.println("Get " + p.getJenis_pelanggaran() + " Pelanggaran");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error getting Pelanggaran...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
        return p;
    }
}
