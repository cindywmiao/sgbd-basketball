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
    private String command;
    private EcritureFichier Ef = null;
    private String fichier;

    public ButtonAdd(String option,EcritureFichier f,String sf){
	this.Ef = f;
	this.fichier = sf;
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
	    if(opt.equals("Club")){
		command = "insert into CLUB values "+
		    "(" + mytable.getValueAt(0,1) +"," + "'"+ mytable.getValueAt(0,2) +"');";
		command += "\ncommit;";
	
	    }
	    else if(opt.equals("Joueur")){
		command = "insert into JOUEUR values "+
		    "(" + mytable.getValueAt(0,1) + ","+  //licence
		    "'"+ mytable.getValueAt(0,2) + "'" + "," + // nom
		    "'"+ mytable.getValueAt(0,3) + "'" + "," + //prenom
		    "'"+ mytable.getValueAt(0,4) + "'" + "," + //naissance
		    "'"+ mytable.getValueAt(0,5) + "'" + "," + //adresse
		    "'"+ mytable.getValueAt(0,6) + "'" + "," + //date d'entree
		    "'"+ mytable.getValueAt(0,7) + "'" + ");"; //club
		command += "\ncommit;";
	
	    }
	    else if(opt.equals("Rencontre")){
		command = "insert into RENCONTRE values "+
		    "(" + mytable.getValueAt(0,1) + ","+ 
		    "'"+ mytable.getValueAt(0,2) + "'" + "," +
		    "'"+ mytable.getValueAt(0,3) + "'" + "," +
		    "'"+ mytable.getValueAt(0,4) + "'" + "," +
		    "'"+ mytable.getValueAt(0,5) + "'" + ");";
		command += "\ncommit;";
	
	    }
	    else if(opt.equals("Equipe")){
		command = "insert into EQUIPE values "+
		    "(" + mytable.getValueAt(0,1) + ","+ 
		    "'"+ mytable.getValueAt(0,2) + "'" + "," +
		    "'"+ mytable.getValueAt(0,3) + "'" + "," +
		    "'"+ mytable.getValueAt(0,4) + "'" + ");";
		command += "\ncommit;";
	
	    }
	    else if(opt.equals("Categorie")) {
		command = "insert into CATEGORIE values "+
		    "(" + mytable.getValueAt(0,1) + ","+ 
		    "'"+ mytable.getValueAt(0,2) + "'" +");";
		command += "\ncommit;";
	
	    }
	    else if(opt.equals("Entraineur")){
		command = "insert into ENTRAINEUR values "+
		    "(" + mytable.getValueAt(0,1) + ","+ 
		    "'"+ mytable.getValueAt(0,2) + "'" + "," +
		    "'"+ mytable.getValueAt(0,3) + "'" + "," +
		    "'"+ mytable.getValueAt(0,4) + "'" + ");";
		command += "\ncommit;";
	
	    }
	    System.out.println(command);
	    Ef.ecrireDuTexte(command,fichier);
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
