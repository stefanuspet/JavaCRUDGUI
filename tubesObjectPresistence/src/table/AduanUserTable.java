/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aduan;

/**
 *
 * @author nayal
 */
public class AduanUserTable extends AbstractTableModel{
      public List<Aduan> list;

    public AduanUserTable(List<Aduan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_aduan();
            case 1:
                return list.get(rowIndex).getPenghuni().getNama();
            case 2:
                return list.get(rowIndex).getTanggal();
            case 3:
                return list.get(rowIndex).getDeskripsi_aduan();
            case 4:
                return list.get(rowIndex).getId_penghuni();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Aduan";
            case 1:
                return "Nama Penghuni";
            case 2:
                return "Tanggal";
            case 3:
                return "Deskripsi Aduan";
            default:
                return null;
        }

    }
    
}
