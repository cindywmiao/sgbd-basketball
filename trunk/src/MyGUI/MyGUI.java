import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class MyGUI implements ActionListener{
    private static JFrame f;
    private static Container contentTitle;
    private JPanel p_title,p_option,p_textarea,p_stats,p_exit;
    private JButton club,joueur,rencontre,bureau,equipe,categorie,entraineur; //niveau 1
    private JButton b_moyenne_rencontre_date,b_moyenne_debut_saison;
    private JButton b_class_joueurs, b_class_equipes;
    private JButton b_update, b_add, b_delete;

    private JTable table;

    public static void main(String argc[]){
    	MyGUI that = new MyGUI();
	that.go();
    }

    public void go(){
	f = new JFrame("GUI Basketball");
	f.setLayout(new GridLayout(5,1));
	f.setSize(800,800);
	f.setLocationRelativeTo(null);
	f.getContentPane().setBackground(Color.white);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	partTitle("BasketBall Club");
	panelOption();
	panelTextArea();
	panelStats();
	panelExit();
	f.setVisible(true);
    }
    void partTitle(String title){;

	contentTitle = f.getContentPane();
	JLabel mytitle = new JLabel("BasketBall Club");
	mytitle.setHorizontalAlignment(JLabel.CENTER);
	mytitle.setBounds(60,90,70,30);
	contentTitle.add(mytitle);
    }
    void panelOption(){
	p_option = new JPanel();

	club = new JButton("Club");
	club.addActionListener(this);
	p_option.add(club);

	bureau = new JButton("Bureau");
	bureau.addActionListener(this);
	p_option.add(bureau);
	
	joueur = new JButton("Joueur");
	joueur.addActionListener(this);
	p_option.add(joueur);
	
	rencontre = new JButton("Rencontre");
	rencontre.addActionListener(this);
	p_option.add(rencontre);

	equipe = new JButton("Equipe");
	equipe.addActionListener(this);
	p_option.add(equipe);

	categorie = new JButton("Categorie");
	categorie.addActionListener(this);
	p_option.add(categorie);
	
	entraineur = new JButton("Entraineur");
	entraineur.addActionListener(this);
	p_option.add(entraineur);

	f.add(p_option);
    }
    void panelTextArea(){
	p_textarea = new JPanel();
	table = new JTable(new MyTable(1));
	table.setPreferredScrollableViewportSize(new Dimension(550, 30));
	JScrollPane s = new JScrollPane(table);
	p_textarea.add(s);
	f.add(p_textarea);
    }
    void panelStats(){
	p_stats = new JPanel();
	 
	b_moyenne_rencontre_date = new JButton("Moyenne des points marqués par rencontre");
	b_moyenne_rencontre_date.addActionListener(this);
	p_stats.add(b_moyenne_rencontre_date);

	b_moyenne_debut_saison = new JButton("Moyenne des points marqués depuis le début de la saison");
	b_moyenne_debut_saison.addActionListener(this);
	p_stats.add(b_moyenne_debut_saison);

	b_class_joueurs = new JButton("Classement des meilleurs joueurs d'une jourenée pour une catégorie");
	b_class_joueurs.addActionListener(this);
	p_stats.add(b_class_joueurs);
	
	b_class_equipes = new JButton("Classement des équipes");
	b_class_equipes.addActionListener(this);
	p_stats.add(b_class_equipes);
    	
	f.add(p_stats); 

    }
    void panelExit(){
	p_exit = new JPanel();

	b_update = new JButton("Update");
	p_exit.add(b_update);
     
	b_add = new JButton("Add");
	p_exit.add(b_add);

	b_delete = new JButton("Delete");
	p_exit.add(b_delete);

	f.add(p_exit);
    }
    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Club"))
	    table.setModel(new MyTable("Club"));
	if (e.getActionCommand().equals("Bureau"))
	    table.setModel(new MyTable(2));
	if (e.getActionCommand().equals("Joueur"))
	    table.setModel(new MyTable(1));
	if (e.getActionCommand().equals("Rencontre"))
	    table.setModel(new MyTable(2));
	if (e.getActionCommand().equals("Equipe"))
	    table.setModel(new MyTable(1));
	if (e.getActionCommand().equals("Categorie"))
	    table.setModel(new MyTable(2));
	if (e.getActionCommand().equals("Entraineur"))
	    table.setModel(new MyTable(1));
	
	if (e.getActionCommand().equals("Moyenne des points marqués par rencontre"))
	    table.setModel(new MyTable(2));
	if (e.getActionCommand().equals("Moyenne des points marqués depuis le début de la saison"))
	    table.setModel(new MyTable(2));
	if (e.getActionCommand().equals("Classement des meilleurs joueurs d'une jourenée pour une catégorie"))
	    table.setModel(new MyTable(2));
	if (e.getActionCommand().equals("Classement des équipes"))
	    table.setModel(new MyTable(2));
	
	table.revalidate();
    }    
}