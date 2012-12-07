import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;

class ButtonAdd implements ActionListener, ListSelectionListener{
    private JFrame FrameAdd;
    private JPanel panelAdd,panelTable;
    private JButton buttonYes, buttonNo;
    private JTable mytable = null;
    private ListSelectionModel selectionMode=null;
    public void go(){
	FrameAdd = new JFrame("Add");
	FrameAdd.setSize(600,100);
	FrameAdd.setLocationRelativeTo(null);
	FrameAdd.getContentPane().setBackground(Color.white);
	FrameAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panelTable = new JPanel();
	String[] name={"Option1","Option2","Option3","Option4","Option5"};
	String[][] data=new String[1][5];
	int value=1;
	for(int i=0;i< data.length;i++){
	    for (int j=0;j< data[i].length;j++){
		data[i][j] = " ";
	    }
	}
	mytable=new JTable(data,name);
	mytable.setCellSelectionEnabled(true);
	mytable.setPreferredScrollableViewportSize(new Dimension(550, 90));
	selectionMode=mytable.getSelectionModel();
	selectionMode.addListSelectionListener(this);
	JScrollPane s = new JScrollPane(mytable);
	panelTable.add(s);
	FrameAdd.add(panelTable,"Center");

	panelAdd = new JPanel();
	buttonYes = new JButton("Add Element");
	buttonYes.addActionListener(this);
	buttonNo = new JButton("Cancel");
	buttonNo.addActionListener(this);
	panelAdd.add(buttonYes);
	panelAdd.add(buttonNo);
	FrameAdd.add(panelAdd,"South");
	FrameAdd.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
			
    	if (e.getActionCommand().equals("Add Element"))
    	    FrameAdd.dispose();
    	else if (e.getActionCommand().equals("Cancel"))
	    FrameAdd.dispose();
	else
	    this.go();
    }

    public void valueChanged(ListSelectionEvent el){
	String tempString="";
      
	int[] rows=mytable.getSelectedRows();
	int[] columns=mytable.getSelectedColumns();

      
	for (int i=0;i< rows.length;i++){
	    for (int j=0;j< columns.length;j++)
                tempString = tempString+" "+(String)mytable.getValueAt(rows[i], columns[j]);      
   	    }
   }
    
}