/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pelanggaran;

/**
 *
 * @author nayal
 */
public class PelanggaranTable extends AbstractTableModel{
    public List<Pelanggaran> list;

    public PelanggaranTable(List<Pelanggaran> list) {
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
                return list.get(rowIndex).getId_pelanggaran();
            case 1:
                return list.get(rowIndex).getJenis_pelanggaran();
            case 2:
                return list.get(rowIndex).getDenda(); 
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Pelanggaran";
            case 1:
                return "Jenis Pelanggaran";
            case 2:
                return "Denda";
            default:
                return null;
        }

    }
    
}
