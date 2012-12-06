import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGUI{
    private static JFrame f;  
    private JPanel p_title,p_option,p_textarea,p_stats,p_exit;
    private JButton club,joueur,rencontre,bureau,equipe,categorie,entraineur; //niveau 1
    private JButton b_moyenne_rencontre_date,b_moyenne_debut_saison;
    private JButton b_class_joueurs, b_class_equipes;
    private JButton b_update, b_add, b_delete;
    private JTextField textfield;
    // public TextArea textarea;
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
	mainPage();
    }

    public void mainPage(){
	panelTitle("BasketBall Club");
	panelOption();
	panelTextArea();
	panelStats();
	panelExit();
	f.setVisible(true);
    }

    void panelTitle(String title){
	p_title = new JPanel();
	JLabel mytitle = new JLabel("BasketBall Club");
	mytitle.setBounds(60,90,70,30);
	p_title.add(mytitle);
	f.add(p_title,"Center");
    }

    void panelOption(){
	p_option = new JPanel();

	club = new JButton("Club");
	club.addActionListener(new ButtonOption("club"));
	p_option.add(club);

	bureau = new JButton("Bureau");
	bureau.addActionListener(new ButtonOption("bureau"));
	p_option.add(bureau);
	
	joueur = new JButton("Joueur");
	joueur.addActionListener(new ButtonOption("joueur"));
	p_option.add(joueur);
	
	rencontre = new JButton("Rencontre");
	rencontre.addActionListener(new ButtonOption("rencontre"));
	p_option.add(rencontre);

	equipe = new JButton("Equipe");
	equipe.addActionListener(new ButtonOption("equipe"));
	p_option.add(equipe);

	categorie = new JButton("Categorie");
	categorie.addActionListener(new ButtonOption("categorie"));
	p_option.add(categorie);
	
	entraineur = new JButton("Entraineur");
	entraineur.addActionListener(new ButtonOption("entraineur"));
	p_option.add(entraineur);

	f.add(p_option);
    }

    void panelTextArea(){
	p_textarea = new JPanel();
	textfield = new JTextField(20);
	p_textarea.add(textfield);
	f.add(p_textarea);
    }

    void panelStats(){

	p_stats = new JPanel();
	//p_stats.setLayout(new GridLayout(4,1));
	 
	b_moyenne_rencontre_date = new JButton("Moyenne des points marqués par rencontre");
	p_stats.add(b_moyenne_rencontre_date);

	b_moyenne_debut_saison = new JButton("Moyenne des points marqués depuis le début de la saison");
	p_stats.add(b_moyenne_debut_saison);

	b_class_joueurs = new JButton("Classement des meilleurs joueurs d'une jourenée pour une catégorie");
	b_class_joueurs.addActionListener(new ButtonClassJoueur());
	p_stats.add(b_class_joueurs);
	
	b_class_equipes = new JButton("Classement des équipes");
	b_class_equipes.addActionListener(new ButtonClassEquipe());
	p_stats.add(b_class_equipes);
    	
	f.add(p_stats); 

    }
    void panelExit(){
	p_exit = new JPanel();

	b_update = new JButton("Update");
	//b_update.addActionListener(new ButtonUpdate());
	p_exit.add(b_update);
      
	b_add = new JButton("Add");
	//b_add.addActionListener(new ButtonExit());
	p_exit.add(b_add);

	b_delete = new JButton("Delete");
	b_delete.addActionListener(new ButtonExit());
	p_exit.add(b_delete);
	
	f.add(p_exit);
    }

    class ButtonOption implements ActionListener{
	private String option = "";
	public ButtonOption(String op){
	    option = op;
	}
	public void actionPerformed(ActionEvent e){	
	    textfield.setText(option);
	}
    }
  
    class ButtonClassEquipe implements ActionListener{
	public void actionPerformed(ActionEvent e){	
	    textfield.setText("Classement des equipe");
	    System.out.println("Classement des equipes");
	}
    }

    
}