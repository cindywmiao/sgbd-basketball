import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

class MyTable extends AbstractTableModel {
    Object[][] p1 = { {new Boolean(false), new Integer(1), "Club 1" },
     		      {new Boolean(false), new Integer(2), "Club 2" }};

    String[] n1 = {" ", "Numero", "NOM"};

    Object[][] p2 = {
	{ new Boolean(false),"Steve", "1234"},
	{ new Boolean(false),"Lily" , "1235" }};

    String[] n2 = {"", "Name", "Numero" };
    
    String[] name = {"Option1","Option2","Option3","Option4","Option5"};
    Object[][] data = new String[1][5];

    int model = 1;
    
    public MyTable(){
	model = 0;
    
    }
    public MyTable(int i) {
	    model = i;
    }

    public MyTable(String option){
	if(option == "Club")
	    model = 1;
    }
    
    

    public int getColumnCount() {
	if (model == 0)
	    return name.length;
	else if (model == 1)
	    return n1.length;
	else
	    return n2.length;
    }

    public int getRowCount() {
	if (model == 0)
	    return data.length;
	else if (model == 1)
	    return p1.length;
	else
	    return p2.length;
    }

    public String getColumnName(int col) {
	if (model == 0)
	    return name[col];
	else if (model == 1)
	    return n1[col];
	else
	    return n2[col];
    }

    public Object getValueAt(int row, int col) {
	if (model == 0)
	    return data[row][col];
	if (model == 1)
	    return p1[row][col];
	else
	    return p2[row][col];
    }

    public Class getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
}