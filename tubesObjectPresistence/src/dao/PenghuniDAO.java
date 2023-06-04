/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Penghuni;
/**
 *
 * @author stefa
 */
public class PenghuniDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insert(Penghuni p){
        con = dbCon.makeConnection();
    }
}
