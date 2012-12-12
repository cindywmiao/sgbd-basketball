import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;

class ButtonDelete implements ActionListener, ListSelectionListener{
    private JFrame FrameDelete;
    private JPanel panelDelete,panelTable;
    private JButton buttonYes, buttonNo;
    private JTable mytable = null;
    private ListSelectionModel selectionMode=null;
    private String opt;
    private String command;
    private EcritureFichier Ef = null;
    private String fichier;

    public ButtonDelete(String option,EcritureFichier f,String sf){
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
    
    public ButtonDelete(){

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
	FrameDelete = new JFrame("Delete");
	FrameDelete.setSize(600,100);
	FrameDelete.setLocationRelativeTo(null);
	FrameDelete.getContentPane().setBackground(Color.white);
	panelTable = new JPanel();
	mytable.setCellSelectionEnabled(true);
	mytable.setPreferredScrollableViewportSize(new Dimension(550, 90));
	selectionMode=mytable.getSelectionModel();
	selectionMode.addListSelectionListener(this);
	JScrollPane s = new JScrollPane(mytable);
	panelTable.add(s);
	FrameDelete.add(panelTable,"Center");

	panelDelete = new JPanel();
	buttonYes = new JButton("Delete Element");
	buttonYes.addActionListener(this);
	buttonNo = new JButton("Cancel");
	buttonNo.addActionListener(this);
	panelDelete.add(buttonYes);
	panelDelete.add(buttonNo);
	FrameDelete.add(panelDelete,"South");
	FrameDelete.setVisible(true);

    }

    protected void getCommand(String optioncommand){
	boolean res = false;
	for(int i = 1; i < mytable.getColumnCount(); i++)
	    if(mytable.getValueAt(0,i) != "" && mytable.getValueAt(0,i) != null)
		{
		    res = true;
		    break;
		}
	if(res){
	    command = "delete from ";
	    command += optioncommand;
	    command += "\nwhere ";
	}
    }

    public void actionPerformed(ActionEvent e) {
	Object tmp = null;
	boolean res = false;	
    	if (e.getActionCommand().equals("Delete Element")){
	    
	    if(opt.equals("Club")){
		getCommand("CLUB");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "club.numero_club = "+ tmp;
		    res = true;}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null)
		    command += " and ";
		if( tmp!= null && tmp!= "")
		    command += "club.nom_club =" + "'"+ tmp +"'";
		command += ";\n";
	    }

	    else if(opt.equals("Categorie")){
		getCommand("CATEGORIE");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "categorie.numero_categorie = "+ tmp;
		    res = true;
		}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null)
		    command += " and ";
		if( tmp!= null && tmp!= "")
		    command += "categorie.nom_categorie =" + "'"+ tmp +"'";
		command += ";\n";
	    }

	    else if(opt.equals("Entraineur")){
		getCommand("ENTRAINEUR");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "entraineur.numero_entraineur = "+ tmp;
		    res = true;
		}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null)
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "entraineur.nom_entraineur =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,3);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "entraineur.prenom_entraineur =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,4);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "entraineur.date_dentree_club_entraineur =" + "'"+ tmp+"'";
		    res = true;
		}
		command += ";\n";
	    }
	    
	     else if(opt.equals("Joueur")){
		getCommand("JOUEUR");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "joueur.numero_joueur = "+ tmp;
		    res = true;
		}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null)
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "joueur.nom_joueur =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,3);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "joueur.prenom_joueur =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,4);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "joueur.date_de_naissance_joueur =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,5);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "joueur.adresse_joueur=" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,6);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "joueur.date_dentree_club_joueur =" + "'"+ tmp +"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,7);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "joueur.numero_club =" + "'"+ tmp +"'";
		    res = true;
		}		
		
		command += ";\n";
	    }

	    else if(opt.equals("Equipe")){
		getCommand("EQUIPE");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "equipe.numero_equipe = "+ tmp;
		    res = true;
		}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null)
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "equipe.nom_equipe =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,3);
		if( res && tmp != "" && tmp != null) 
		    command += " and ";
		if( tmp!= null && tmp!= "" && tmp != "0"){
		    command += "equipe.numero_club =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,4);
		if( res && tmp != "" && tmp != null && tmp != "0") 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "equipe.numero_caterogie=" + "'"+ tmp+"'";
		    res = true;
		}
		command += ";\n";
	    }
	  
	    else if(opt.equals("Rencontre")){
		getCommand("RENCONTRE");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "rencontre.numero_rencontre = "+ tmp;
		    res = true;
		}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null && tmp != "0")
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "rencontre.score_equipe1=" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,3);
		if( res && tmp != "" && tmp != null && tmp != "0") 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "rencontre.score_equipe2 =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,4);
		if( res && tmp != "" && tmp != null && tmp != "0" ) 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "rencontre.numero_equipe1 =" + "'"+ tmp+"'";
		    res = true;
		}
		tmp = mytable.getValueAt(0,5);
		if( res && tmp != "" && tmp != null && tmp != "0") 
		    command += " and ";
		if( tmp!= null && tmp!= ""){
		    command += "rencontre.numero_equipe2 =" + "'"+ tmp+"'";
		    res = true;
		}
		command += ";\n";
	    }
	   
	    System.out.println(command);
	    Ef.ecrireDuTexte(command,fichier);
    	    FrameDelete.dispose();
	}
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
