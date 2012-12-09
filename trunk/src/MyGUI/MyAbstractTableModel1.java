import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn; 
 
class MyAbstractTableModel1 extends AbstractTableModel {  
    String[] head = { " ","ID", "NAME", "AGE", "DEMO" };  
 
    Object[] data1 = { new Boolean(false),  "200913420125", "SUMMER", new Integer(20),  "NULL" };  
    Object[] data2 = { new Boolean(false),   "200913420124", "WULEI",  new Integer(20),  "NULL" };  
    Object[] data3 = { new Boolean(false), "200913420125", "BOOK",  new Integer(20),  "NULL" };  
    Object[] data4 = {new Boolean(false),  "200913420125", "CUP",  new Integer(20), "NULL" };  
    Object[] data5 = { new Boolean(false),  "200913420125", "MOUSE", new Integer(20), "NULL" };   
  
    Class[] typeArray = {Boolean.class,   Object.class, Object.class, 
            Integer.class, Object.class };  
  
    Object[][] data = { data1, data2, data3, data4, data5 };  
  
    public int getColumnCount() {  
        return head.length;  
    }  
  
    public int getRowCount() {  
        return data.length;  
    }  
  
    @Override  
    public String getColumnName(int column) {  
        return head[column];  
    }  
  
    public Object getValueAt(int rowIndex, int columnIndex) {  
        return data[rowIndex][columnIndex];  
    }  
  
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return true;  
    }  
  
  
    @Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
        data[rowIndex][columnIndex] = aValue;  
        fireTableCellUpdated(rowIndex, columnIndex);  
    }  

    public Class getColumnClass(int columnIndex) {  
        return typeArray[columnIndex];
    }  
}  