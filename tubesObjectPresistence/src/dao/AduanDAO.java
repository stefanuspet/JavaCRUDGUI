package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Aduan;
import control.PenghuniControl;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Penghuni;
public class AduanDAO {
    
    private DbConnection dbConnection = new DbConnection();
    private Connection con;

    private PenghuniControl pc = new PenghuniControl();
    public void insertAduan(Aduan a){
        con = dbConnection.makeConnection();
        String sql ="INSERT INTO aduan(id_penghuni, tanggal, deskripsi_aduan) "
                + "VALUES ('"+a.getId_penghuni()+"','"+a.getTanggal()+"','"+a.getDeskripsi_aduan()+"')";
        System.out.println("Adding Aduan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Aduan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Aduan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void deleteAduan(int id_aduan){
        con = dbConnection.makeConnection();
        String sql ="DELETE FROM aduan WHERE id_aduan='"+id_aduan+"'";
        System.out.println("Deleting Aduan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Aduan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Aduan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void updateAduan(Aduan a, int id_aduan){
        con = dbConnection.makeConnection();
        String sql ="UPDATE aduan SET id_penghuni='"+a.getId_penghuni()+"', tanggal='"+a.getTanggal()+"', deskripsi_aduan='"+a.getDeskripsi_aduan()+"' WHERE id_aduan='"+id_aduan+"'";
        System.out.println("Updating Aduan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Aduan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Aduan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    //kurang select aduan
    public ArrayList<Aduan> showAduan(String query){
        con = dbConnection.makeConnection();
        ArrayList<Aduan> aduanList = new ArrayList<>();
        String sql = "SELECT * FROM aduan a JOIN penghuni p ON a.id_penghuni = p.id_penghuni WHERE " +
                "a.id_aduan LIKE '%"+query+"p.nama_penghuni LIKE '%"+query+"%' OR a.tanggal LIKE '%"+query+"%' OR a.deskripsi_aduan LIKE '%"+query+"%'";
        System.out.println("Showing Aduan....");
        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()) {
                Aduan aduan = new Aduan(result.getInt("id"),
                        pc.searchPenghuni(result.getInt("id_penghuni")),
                        result.getString("tanggal"),
                        result.getString("deskripsi_aduan"));
                aduanList.add(aduan);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("Error showing Aduan...");
            System.out.println(e);
        }
        return aduanList;
    }

    public ArrayList<Aduan> showAduanByPenghuni(String id_penghuni, String query){
        con = dbConnection.makeConnection();
        ArrayList<Aduan> aduanList = new ArrayList<>();
        String sql = "SELECT * FROM aduan a JOIN penghuni p ON a.id_penghuni = p.id_penghuni WHERE p.id_penghuni = '"+id_penghuni+"'";
        System.out.println("Showing Aduan....");
        try {
            Statement statement = con.createStatement();
            statement.executeQuery(sql);
            var result = statement.getResultSet();
            while (result.next()) {
                Aduan aduan = new Aduan(result.getInt("id_aduan"),
                        pc.searchPenghuni(result.getInt("id_penghuni")),
                        result.getString("tanggal"),
                        result.getString("deskripsi_aduan"));
                aduanList.add(aduan);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("Error showing Aduan...");
            System.out.println(e);
        }
        return aduanList;
    }
    
    public List<Aduan> searchAduanTable(String id_penghuni, String query) {
        con = dbConnection.makeConnection();
        String sql = "SELECT * FROM aduan WHERE (id_penghuni = '"+id_penghuni+"') AND (id_aduan LIKE '%"+query+"%'  OR tanggal LIKE '%"+query+"%' OR deskripsi_aduan LIKE '%"+query+"%')";
        System.out.println("Mengambil Data Penghuni ...");
        List<Aduan> list = new ArrayList();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            var result = statement.getResultSet();
            if (rs != null) {
                while (rs.next()) {
                    Aduan a = new Aduan(
                            rs.getInt("id_aduan"),
                            pc.searchPenghuni(result.getInt("id_penghuni")),
                            rs.getString("tanggal"),
                            rs.getString("deskripsi_aduan")
                            
                    );

                    list.add(a);
                }
            }
            System.out.println(id_penghuni);
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Reading Database...");
            throw new RuntimeException(e);
        }
        dbConnection.closeConnection();
        return list;
    }
}
