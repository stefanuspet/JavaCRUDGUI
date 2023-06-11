package dao;

import connection.DbConnection;
import java.util.ArrayList;
import java.util.List;
import model.Kamar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KamarDAO {

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    public void insertKamar(Kamar k) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO kamar(nama_kamar, fasilitas, harga_sewa, deskripsi, status) "
                + "VALUES ('" + k.getNamaKamar() + "','" + k.getFasilitas() + "','" + k.getHarga_sewa() + "','" + k.getDeskripsi() + "','" + k.getStatus() + "')";
        System.out.println("Adding Kamar....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    public void updateKamar(Kamar k, int id_kamar) {
        con = dbCon.makeConnection();
        // sql = UPDATE `kamar` SET `nama_kamar`='[value-2]',`fasilitas`='[value-3]',`harga_sewa`='[value-4]',`deskripsi`='[value-5]',`status`='[value-6]' WHERE 1
        String sql = "UPDATE kamar SET nama_kamar='" + k.getNamaKamar() + "', fasilitas='" + k.getFasilitas() + "', harga_sewa='" + k.getHarga_sewa() + "', deskripsi='" + k.getDeskripsi() + "', status='" + k.getStatus() + "' WHERE id_kamar='" + id_kamar + "'";
        System.out.println("Updating Kamar....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    public void deleteKamar(int id_kamar) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM kamar WHERE id_kamar='" + id_kamar + "'";
        System.out.println("Deleting Kamar....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    public ArrayList<Kamar> showKamar() {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kamar";
        System.out.println("Mengambil Data Kamar ...");
        ArrayList<Kamar> list = new ArrayList();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Kamar k = new Kamar(
                            rs.getInt("id_kamar"),
                            rs.getString("nama_kamar"),
                            rs.getString("fasilitas"),
                            rs.getInt("harga_sewa"),
                            rs.getString("deskripsi"),
                            rs.getString("status")
                    );
                    list.add(k);
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error getting Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }

    public Kamar getKamar(int id_kamar) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kamar WHERE id_kamar='" + id_kamar + "'";
        System.out.println("Mengambil Data Kamar ...");
        Kamar k = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    k = new Kamar(
                            rs.getInt("id_kamar"),
                            rs.getString("nama_kamar"),
                            rs.getString("fasilitas"),
                            rs.getInt("harga_sewa"),
                            rs.getString("deskripsi"),
                            rs.getString("status")
                    );
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error getting Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return k;
    }

    public List<Kamar> searchKamarTable(String query) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kamar WHERE id_kamar LIKE '%" + query + "%' OR nama_kamar LIKE '%" + query + "%'"
                + "OR fasilitas LIKE '%" + query + "%' OR harga_sewa LIKE '%" + query + "%' OR deskripsi LIKE '%" + query + "%' OR status LIKE '%" + query + "%'";
        System.out.println("Mengambil Data Penghuni ...");
        List<Kamar> list = new ArrayList();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Kamar k = new Kamar(
                            rs.getInt("id_kamar"),
                            rs.getString("nama_kamar"),
                            rs.getString("fasilitas"),
                            rs.getInt("harga_sewa"),
                            rs.getString("deskripsi"),
                            rs.getString("status")
                    );

                    list.add(k);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Reading Database...");
            throw new RuntimeException(e);
        }
        dbCon.closeConnection();
        return list;
    }
}
