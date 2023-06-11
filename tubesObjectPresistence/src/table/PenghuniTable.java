/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penghuni;

/**
 *
 * @author nayal
 */
public class PenghuniTable extends AbstractTableModel{
    public List<Penghuni> list;
    
    public PenghuniTable(List<Penghuni> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_penghuni();
            case 1:
                return list.get(rowIndex).getUsername();
            case 2:
                return list.get(rowIndex).getPassword();
            case 3:
                return list.get(rowIndex).getNama();
            case 4:
                return list.get(rowIndex).getNo_telp();
            case 5:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Penghuni";
            case 1:
                return "Username";
            case 2:
                return "Password";
            case 3:
                return "Nama";
            case 4:
                return "No Telepon";
            case 5:
                 return "Alamat";
            default:
                return null;
        }

    }
    
}
