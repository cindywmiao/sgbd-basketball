import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;

class ButtonDelete implements ActionListener, ListSelectionListener{
    private JFrame FrameDelete;
    private JPanel panelDelete,panelTable;
    private JButton buttonFind,buttonYes, buttonNo;
    private JTable mytable = null;
    private ListSelectionModel selectionMode=null;
    public void go(){
	FrameDelete = new JFrame("Delete");
	FrameDelete.setSize(600,100);
	FrameDelete.setLocationRelativeTo(null);
	FrameDelete.getContentPane().setBackground(Color.white);
	FrameDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	FrameDelete.add(panelTable,"Center");

	panelDelete = new JPanel();
	buttonFind = new JButton("Find Element");
	buttonFind.addActionListener(this);
	buttonYes = new JButton("Delete Element");
	buttonYes.addActionListener(this);
	buttonNo = new JButton("Cancel");
	buttonNo.addActionListener(this);
	panelDelete.add(buttonFind);
	panelDelete.add(buttonYes);
	panelDelete.add(buttonNo);
	FrameDelete.add(panelDelete,"South");
	FrameDelete.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Find Element"))
	    mytable.setModel(new MyTable(2));//show the element
    	else if (e.getActionCommand().equals("Delete Element"))
    	    FrameDelete.dispose();
    	else if (e.getActionCommand().equals("Cancel"))
	    FrameDelete.dispose();
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