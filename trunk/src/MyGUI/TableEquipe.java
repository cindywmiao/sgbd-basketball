import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn; 
 
class TableEquipe extends AbstractTableModel {  
    String[] head = { " ","NUMERO","NOM", "CLUB","CATEGORIE"};  
    Object[] data0 = { new Boolean(true) ,"","",0,0};
    Object[] data1 = { new Boolean(false),  "200913420125" ,"CUT"  , 1,1};  
    Object[] data2 = { new Boolean(false),  "200913420124" ,"BOOK" , 2,2};  
    Object[] data3 = { new Boolean(false),  "200913420125" ,"SUM"  , 3,3};  
    Object[] data4 = { new Boolean(false),  "200913420125" ,"NOM " , 4,4};  
    Object[] data5 = { new Boolean(false),  "200913420125" ,"RIG"  , 5,5};   
  
    Class[] typeArray = {Boolean.class,  //bool   
			 Object.class,   //numero
			 Object.class,   //nom
			 Integer.class,
			 Integer.class
    };  
  
   
    Object[][] data = { data1, data2, data3, data4, data5 };  
    public JTable t = null;

    public TableEquipe(){
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