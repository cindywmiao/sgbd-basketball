import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn; 
 
class TableEntraineur extends AbstractTableModel {  
    String[] head = { " ","NUMERO","NOM", "PRENOM","DATE D'ENTREE CLUB" };  
    Object[] data0 = { new Boolean(true) ,"0","","","",""};
    Object[] data1 = { new Boolean(false),  "200913420125" , "SUMMER" , "MILLE" ,"12-FEV-98" };  
    Object[] data2 = { new Boolean(false),  "200913420124" , "WULEI"  , "MILLE" ,"12-FEV-98" };  
    Object[] data3 = { new Boolean(false),  "200913420125" , "BOOK"   , "MILLE" ,"12-DEC-85" };  
    Object[] data4 = { new Boolean(false),  "200913420125" , "CUP"    , "MILLE" ,"12-DEC-85" };  
    Object[] data5 = { new Boolean(false),  "200913420125" , "MOUSE"  , "MILLE" ,"12-DEC-85" };   
  
    Class[] typeArray = {Boolean.class,  //bool   
			 Object.class,   //numero
			 Object.class,   //nom
			 Object.class,   //prenom
			 Object.class,   //date de entree
    };  
  
    Object[][] data = { data1, data2, data3, data4, data5 };  
    public JTable t = null;

    public TableEntraineur(){
	Object[][] data= {data0};
	// String[] newhead = new String[2];
	// for(int i = 1; i < head.length; i++)
	//     newhead[i - 1]= head[i];
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
    }  

    public Class getColumnClass(int columnIndex) {  
        return typeArray[columnIndex];
    }  
}  