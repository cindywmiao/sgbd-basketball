import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn;  


public class MyGUI implements ActionListener,ListSelectionListener{
    private static JFrame myJFrame;
    private static Container contentTitle;
    private static JPanel panelOption,panelTable,panelStatistique,panelUpdate;
    private static JButton club,joueur,rencontre,equipe,categorie,entraineur;
    private static JButton b_moyenne_rencontre_date,b_moyenne_debut_saison;
    private static JButton b_class_joueurs, b_class_equipes;
    private static JButton buttonUpdate, buttonAdd, buttonDelete;
    private static JTable table = null;
    private JComboBox cob = null;  
    private JCheckBox ckb = null;  
    private JTextField txt = null;  
    private ListSelectionModel selectionMode=null;

    public String option = "Club";

    public static void main(String argc[]){
    	MyGUI that = new MyGUI();
	that.go();
    }

    public void go(){
	myJFrame = new JFrame("GUI Basketball");
	myJFrame.setLayout(new GridLayout(5,1));
	myJFrame.setSize(800,800);
	myJFrame.setLocationRelativeTo(null);
	myJFrame.getContentPane().setBackground(Color.white);
	myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	partTitle("BasketBall Club");
	panelOption();
	panelTextArea();
	panelStats();
	panelExit();
	myJFrame.setVisible(true);
    }
    void partTitle(String title){

	contentTitle = myJFrame.getContentPane();
	JLabel mytitle = new JLabel("BasketBall Club");
	mytitle.setHorizontalAlignment(JLabel.CENTER);
	mytitle.setBounds(60,90,70,30);
	contentTitle.add(mytitle);
    }
    void panelOption(){
	panelOption = new JPanel();

	club = new JButton("Club");
	club.addActionListener(this);
	panelOption.add(club);
	
	joueur = new JButton("Joueur");
	joueur.addActionListener(this);
	panelOption.add(joueur);
	
	rencontre = new JButton("Rencontre");
	rencontre.addActionListener(this);
	panelOption.add(rencontre);

	equipe = new JButton("Equipe");
	equipe.addActionListener(this);
	panelOption.add(equipe);

	categorie = new JButton("Categorie");
	categorie.addActionListener(this);
	panelOption.add(categorie);
	
	entraineur = new JButton("Entraineur");
	entraineur.addActionListener(this);
	panelOption.add(entraineur);

	myJFrame.add(panelOption);
    }
    void panelTextArea(){
	panelTable = new JPanel();
	MyAbstractTableModel1 myModel = new MyAbstractTableModel1();  
  
        table = new JTable(myModel);  
        TableColumn tc1 = table.getColumnModel().getColumn(2);  
        TableColumn tc3 = table.getColumnModel().getColumn(4);  
        ckb = new JCheckBox();  
        tc1.setCellEditor(new DefaultCellEditor(ckb));  
    
        txt = new JTextField("");  
        txt.setSize(100, 26);  
        tc3.setCellEditor(new DefaultCellEditor(txt));  
  
	JScrollPane s = new JScrollPane(table);
	panelTable.add(s);
	myJFrame.add(panelTable);
    }
    void panelStats(){
	panelStatistique = new JPanel();
	 
	b_moyenne_rencontre_date = new JButton("Moyenne des points marques par rencontre");
	b_moyenne_rencontre_date.addActionListener(this);
	panelStatistique.add(b_moyenne_rencontre_date);

	b_moyenne_debut_saison = new JButton("Moyenne des points marques depuis le debut de la saison");
	b_moyenne_debut_saison.addActionListener(this);
	panelStatistique.add(b_moyenne_debut_saison);

	b_class_joueurs = new JButton("Classement des meilleurs joueurs d'une jourenee pour une categorie");
	b_class_joueurs.addActionListener(this);
	panelStatistique.add(b_class_joueurs);
	
	b_class_equipes = new JButton("Classement des equipes");
	b_class_equipes.addActionListener(this);
	panelStatistique.add(b_class_equipes);
    	
	myJFrame.add(panelStatistique); 

    }
    void panelExit(){
	panelUpdate = new JPanel();

	buttonUpdate = new JButton("Update");
	buttonUpdate.addActionListener(this);
	panelUpdate.add(buttonUpdate);
     
	buttonAdd = new JButton("Add");
	buttonAdd.addActionListener(this);
	panelUpdate.add(buttonAdd);

	buttonDelete = new JButton("Delete");
	buttonDelete.addActionListener(this);
	panelUpdate.add(buttonDelete);

	myJFrame.add(panelUpdate);
    }
    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Club")){
	    option = "Club";
	    table.setModel(new TableClub());
	}
	if (e.getActionCommand().equals("Joueur")){
	    option = "Joueur";
	    table.setModel(new TableJoueur());
	}
	if (e.getActionCommand().equals("Rencontre")){
	    option = "Rencontre";
	    table.setModel(new TableRencontre());
	}
	if (e.getActionCommand().equals("Equipe")){
	    option = "Equipe";
	    table.setModel(new TableEquipe());
	}
	if (e.getActionCommand().equals("Categorie")){
	    table.setModel(new TableCategorie());
	    option = "Categorie";
	}
	if (e.getActionCommand().equals("Entraineur")){
	    table.setModel(new TableEntraineur());
	    option = "Entraineur";
	}
       
	
	if (e.getActionCommand().equals("Moyenne des points marques par rencontre")){
	    //table.setModel(new MyTable(2));option = null;
	    option = null;
	    MyFrame1 myframe1 = new MyFrame1();
	    myframe1.actionPerformed(e);
	}
	if (e.getActionCommand().equals("Moyenne des points marques depuis le debut de la saison")){
	    //table.setModel(new MyTable(2));option = null;
	    option = null;
	    MyFrame2 myframe2 = new MyFrame2();
	    myframe2.actionPerformed(e);
	}
	if (e.getActionCommand().equals("Classement des meilleurs joueurs d'une jourenee pour une categorie")){
	    //table.setModel(new MyTable(2));option = null;
	    option = null;
	    MyFrame3 myframe3 = new MyFrame3();
	    myframe3.actionPerformed(e);
	}
	if (e.getActionCommand().equals("Classement des equipes")){
		System.out.println("select num_equipe, sum(score) as Score\n" +
		"from(\n" +	
		"(select rencontre.numero_equipe1 as NUM_EQUIPE , rencontre.score_equipe1_rencontre as SCORE\n"+
		"from rencontre)\n"+
		"union\n"+
		"(select rencontre.numero_equipe2 as NUM_EQUIPE , rencontre.score_equipe2_rencontre as SCORE\n"+
		"from rencontre))\n"+
		"group by NUM_EQUIPE\n"+
		"order by Score DESC;");
	    table.setModel(new MyTable(2)); option = null;
	}
	
	if (e.getActionCommand().equals("Add")){
	    
	    ButtonAdd buttonAddClass = new ButtonAdd(option);
	    buttonAddClass.actionPerformed(e);
	}

	if (e.getActionCommand().equals("Update")){
	    ButtonUpdate buttonUpdateClass = new ButtonUpdate(option);
	    buttonUpdateClass.actionPerformed(e);
	}
	
	if (e.getActionCommand().equals("Delete")){
	  	ButtonDelete buttonDeleteClass = new ButtonDelete(option);
	    buttonDeleteClass.actionPerformed(e);
	}
	
	
	table.revalidate();
    } 

    public void valueChanged(ListSelectionEvent el){
	String tempString="";
	Integer tempInteger = 0;
	Boolean tempBoolean = false;
	
	int[] rows=table.getSelectedRows();
	int[] columns=table.getSelectedColumns();
    }
}

