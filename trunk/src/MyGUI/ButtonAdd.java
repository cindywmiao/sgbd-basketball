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
    private String opt;

    public ButtonAdd(String option){
	opt = option;
	if(opt.equals("Club")){
	    TableClub tableclub = new TableClub();
	    mytable = tableclub.t;
	}
	else if(opt.equals("Joueur")){
	    TableJoueur tablejoueur = new TableJoueur();
	    mytable = tablejoueur.t;
	}
	else if(opt.equals("Rencontre")){
	    TableRencontre tablerencontre = new TableRencontre();
	    mytable = tablerencontre.t;
	}
	else if(opt.equals("Equipe")){
	    TableEquipe tableequipe = new TableEquipe();
	    mytable = tableequipe.t;
	}
        else if(opt.equals("Categorie")){
	    TableCategorie tablecategorie = new TableCategorie();
	    mytable = tablecategorie.t;
	}
	else if(opt.equals("Entraineur")){
	    TableEntraineur tableentraineur = new TableEntraineur();
	    mytable = tableentraineur.t; 
	}
	else 
	    mytable = null;
	    //mytable = new TableClub();
    }
    
    public ButtonAdd(){

	String[] name={"Opt1","Opt2","Opt3","Opt4","Opt5"};
	String[][] data=new String[1][5];
	int value=1;
	for(int i=0;i< data.length;i++){
	    for (int j=0;j< data[i].length;j++){
		data[i][j] = " ";
	    }
	}
	mytable=new JTable(data,name);
    }

    public void go(){
	FrameAdd = new JFrame("Add");
	FrameAdd.setSize(600,100);
	FrameAdd.setLocationRelativeTo(null);
	FrameAdd.getContentPane().setBackground(Color.white);
	panelTable = new JPanel();
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
			
    	if (e.getActionCommand().equals("Add Element")){
	    if(opt.equals("Club"))
		System.out.println("insert into CLUB values "+
				   "(" + mytable.getValueAt(0,1) +"," + "'"+ mytable.getValueAt(0,2) +"');");
	    else if(opt.equals("Joueur"))
		System.out.println("insert into JOUEUR values "+
				   "(" + mytable.getValueAt(0,1) + ","+  //licence
				   "'"+ mytable.getValueAt(0,2) + "'" + "," + // nom
				   "'"+ mytable.getValueAt(0,3) + "'" + "," + //prenom
				   "'"+ mytable.getValueAt(0,4) + "'" + "," + //date de naissance
				   "'"+ mytable.getValueAt(0,5) + "'" + "," + //adresse
				   "'"+ mytable.getValueAt(0,6) + "'" + "," + //date d'entree club
				   "'"+ mytable.getValueAt(0,7) + "'" + ");"); //club
	    else if(opt.equals("Rencontre"))
		System.out.println("insert into RENCONTRE values "+
				   "(" + mytable.getValueAt(0,1) + ","+ 
				   "'"+ mytable.getValueAt(0,2) + "'" + "," +
				   "'"+ mytable.getValueAt(0,3) + "'" + "," +
				   "'"+ mytable.getValueAt(0,4) + "'" + "," +
				   "'"+ mytable.getValueAt(0,5) + "'" + ");");
	    else if(opt.equals("Equipe"))
		System.out.println("insert into EQUIPE values "+
				   "(" + mytable.getValueAt(0,1) + ","+ 
				   "'"+ mytable.getValueAt(0,2) + "'" + "," +
				   "'"+ mytable.getValueAt(0,3) + "'" + "," +
				   "'"+ mytable.getValueAt(0,4) + "'" + ");");
	    else if(opt.equals("Categorie"))
		System.out.println("insert into CATEGORIE values "+
				   "(" + mytable.getValueAt(0,1) + ","+ 
				   "'"+ mytable.getValueAt(0,2) + "'" +");");
	    else if(opt.equals("Entraineur"))
		System.out.println("insert into ENTRAINEUR values "+
				   "(" + mytable.getValueAt(0,1) + ","+ 
				   "'"+ mytable.getValueAt(0,2) + "'" + "," +
				   "'"+ mytable.getValueAt(0,3) + "'" + "," +
				   "'"+ mytable.getValueAt(0,4) + "'" + ");");

    	    FrameAdd.dispose();
	}
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
