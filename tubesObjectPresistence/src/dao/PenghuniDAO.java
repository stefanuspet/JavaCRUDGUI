/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Penghuni;
/**
 *
 * @author stefa
 */
public class PenghuniDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertPenghuni(Penghuni p){
        con = dbCon.makeConnection();
        String sql ="INSERT INTO penghuni(username, password, nama, alamat, no_telp, tanggal_masuk, tanggal_keluar) "
                + "VALUES ('"+p.getUsername()+"','"+p.getPassword()+"','"+p.getNama()+"','"+p.getAlamat()+"','"+p.getNo_telp()+"','"+p.getTanggal_masuk()+"','"+p.getTanggal_keluar()+"')";
        System.out.println("Adding Penghuni....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Penghuni");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Penghuni...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Penghuni> showPenghuni(){
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM penghuni";
        System.out.println("Mengambil Data Dosen ...");
        List<Penghuni> list = new ArrayList();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
//                    Penghuni p = new Penghuni(0, sql, sql, sql, sql, sql, sql, sql);
                    Penghuni p = new Penghuni(
                            rs.getInt("id_penghuni"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getString("no_telp"),
                            rs.getString("tanggal_masuk"),
                            rs.getString("tanggal_keluar")
                    );
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Reading Database...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return list;
    }
    
    public void UpdatePenghuni(Penghuni p, int id){
        con = dbCon.makeConnection();

        String sql = "UPDATE penghuni SET username='"+p.getUsername()+"',"
                + "password='"+p.getPassword()+"',"
                + "nama='"+p.getNama()+"',"
                + "alamat='"+p.getAlamat()+"',"
                + "no_telp='"+p.getNo_telp()+"',"
                + "tanggal_masuk='"+p.getTanggal_masuk()+"',"
                + "tanggal_keluar='"+p.getTanggal_keluar()+"'"
                + "WHERE id_penghuni = '" + id + "'";
        System.out.println("Editing Dosen ...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + "Penghuni " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Editing Database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void DeletePenghuni(String nama){
        con = dbCon.makeConnection();

        String sql = "DELETE FROM penghuni WHERE id_penghuni = '"+nama+"'";
        System.out.println("DELETING Penghuni ...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + "Penghuni " + nama);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
}
