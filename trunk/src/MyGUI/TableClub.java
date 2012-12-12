import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn; 
 
class TableClub extends AbstractTableModel {  
    String[] head = { " ","NUMERO","NOM" };  
    
    Object[] data0 = { new Boolean(true) ,"0",""};
    Object[] data1 = { new Boolean(false),  "125" , "SUMMER" };  
    Object[] data2 = { new Boolean(false),  "224" , "WULEI"  };  
    Object[] data3 = { new Boolean(false),  "205" , "BOOK"   };  
    Object[] data4 = { new Boolean(false),  "215" , "CUP"    };  
    Object[] data5 = { new Boolean(false),  "200" , "MOUSE"  };   
  
    Class[] typeArray = {Boolean.class, Object.class, Object.class  };  
    
  
    Object[][] data = { data1, data2, data3, data4, data5 }; 
    
    public JTable t = null;

    public TableClub(){
	Object[][] data= {data0};
	t = new JTable(data,head);
    }
   
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

	System.out.println(aValue);
    }  

    public Class getColumnClass(int columnIndex) {  
        return typeArray[columnIndex];
    }  
}  