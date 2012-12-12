import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;

class ButtonUpdate implements ActionListener, ListSelectionListener{
    private JFrame FrameUpdate;
    private JPanel panelUpdate,panelTable;
    private JButton buttonFind,buttonYes, buttonNo;
    private JTable mytable = null;
    private ListSelectionModel selectionMode=null;
    private String opt;
    private String command1= "", command2="";
    private EcritureFichier Ef = null;
    private String fichier = null;
    private boolean res1= false;
    
    public ButtonUpdate(String option,EcritureFichier f,String sf){
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
	    //mytable = new TableClub();
    }
    public ButtonUpdate(){

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
	FrameUpdate = new JFrame("Update");
	FrameUpdate.setSize(600,100);
	FrameUpdate.setLocationRelativeTo(null);
	FrameUpdate.getContentPane().setBackground(Color.white);
	panelTable = new JPanel();
	mytable.setCellSelectionEnabled(true);
	mytable.setPreferredScrollableViewportSize(new Dimension(550, 90));
	selectionMode=mytable.getSelectionModel();
	selectionMode.addListSelectionListener(this);
	JScrollPane s = new JScrollPane(mytable);
	panelTable.add(s);
	FrameUpdate.add(panelTable,"Center");

	panelUpdate = new JPanel();
	buttonFind = new JButton("Find Element");
	buttonFind.addActionListener(this);
	buttonYes = new JButton("Update Element");
	buttonYes.addActionListener(this);
	buttonNo = new JButton("Cancel");
	buttonNo.addActionListener(this);
	panelUpdate.add(buttonFind);
	panelUpdate.add(buttonYes);
	panelUpdate.add(buttonNo);
	FrameUpdate.add(panelUpdate,"South");
	FrameUpdate.setVisible(true);

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
   	protected String action1(){
   		String command = "";
   		Object tmp = null;
		boolean res = false;		
    	if(opt.equals("Club")){
			getCommand("CLUB");
		tmp = mytable.getValueAt(0,1);
		if( tmp != "" && tmp != null){
		    command += "club.numero_club = "+ tmp;
		    res = true;
		}
		tmp = mytable.getValueAt(0,2);
		if( res && tmp != "" && tmp != null)
		    command += " and ";
		if( tmp!= null && tmp!= "")
		    command += "club.nom_club =" + "'"+ tmp +"'";
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
   }
   	return command;
   }  
   	protected boolean getCommand(String optioncommand){
	boolean res = false;
	for(int i = 1; i < mytable.getColumnCount(); i++)
	    if(mytable.getValueAt(0,i) != "" && mytable.getValueAt(0,i) != null && mytable.getValueAt(0,i) != "0")
		{
		    res = true;
		    break;
		}
	return res;
    }
   	public void actionPerformed(ActionEvent e) {
   		
   		if (e.getActionCommand().equals("Find Element")){
   			res1 = getCommand(opt);
   			command2 = action1();
   			
   			for(int i = 1; i < mytable.getColumnCount();i++)
   				mytable.setValueAt("",0,i);

      	}else if (e.getActionCommand().equals("Update Element")){
      		if(res1 && getCommand(opt)){
      		command1 = "update " + opt ;
            command1 += " set ";
            command1 += action1();
            command1 += " where ";
            command1 += command2;
            command1 += ";\ncommit;";
            System.out.println(command1);
            Ef.ecrireDuTexte(command1,fichier);
            }
			FrameUpdate.dispose();
      	}else if (e.getActionCommand().equals("Cancel"))
      		FrameUpdate.dispose();
		else
			this.go();
    } 
}
