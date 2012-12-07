import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

class MyTable extends AbstractTableModel {

    Object[][] p1 = { { "Steve", "1234", new Integer(66), new Integer(50),
			new Integer(116), new Boolean(false), new Boolean(false) } };

    String[] n1 = { "Name", "Numero", "Chinese", "Math", "Somme", "Moyenne", "..." };

    Object[][] p2 = {
	{ "Steve", "1234", new Integer(50), new Boolean(false),
	  new Boolean(false), "01234" },
	{ "Lily", "1235", new Integer(75), new Boolean(true),
	  new Boolean(false), "05678" } };

    String[] n2 = { "Name", "Numero", "Math", "Moyenne", "Adresse", "Telephone" };

    int model = 1;
    
    public MyTable(int i) {
	    model = i;
    }

    public MyTable(String option){
	if(option == "Club")
	    model = 1;
    }
    
    

    public int getColumnCount() {
	if (model == 1)
	    return n1.length;
	else
	    return n2.length;
    }

    public int getRowCount() {
	if (model == 1)
	    return p1.length;
	else
	    return p2.length;
    }

    public String getColumnName(int col) {
	if (model == 1)
	    return n1[col];
	else
	    return n2[col];
    }

    public Object getValueAt(int row, int col) {
	if (model == 1)
	    return p1[row][col];
	else
	    return p2[row][col];
    }

    public Class getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
}