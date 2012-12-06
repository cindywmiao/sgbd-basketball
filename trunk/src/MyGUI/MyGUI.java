import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGUI{
    public JFrame f;
   
    public Panel p_title,p_option,p_textarea,p_stats,p_exit;
    public Button club,joueur,rencontre,bureau,equipe,categorie,entraineur;
    public Button b_moyenne_rencontre_date,b_moyenne_debut_saison;
    public Button b_class_joueurs, b_class_equipes;
    public Button b_update, b_exit;
    public JTextField textfield;
    // public TextArea textarea;
    public static void main(String argc[]){
	MyGUI that = new MyGUI();
	that.go();
    }
    public void go(){
	f = new JFrame("GUI Basketball");
	f.setLayout(new GridLayout(5,1));
	f.setSize(600,800);
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
	p_title = new Panel();
	p_title.add(new Label(title));
	f.add(p_title);
    }

    void panelOption(){
	p_option = new Panel();

	club = new Button("Club");
	club.addActionListener(new ButtonOption("club"));
	p_option.add(club);

	bureau = new Button("Bureau");
	bureau.addActionListener(new ButtonOption("bureau"));
	p_option.add(bureau);
	
	joueur = new Button("Joueur");
	joueur.addActionListener(new ButtonOption("joueur"));
	p_option.add(joueur);
	
	rencontre = new Button("Rencontre");
	rencontre.addActionListener(new ButtonOption("rencontre"));
	p_option.add(rencontre);

	equipe = new Button("Equipe");
	equipe.addActionListener(new ButtonOption("equipe"));
	p_option.add(equipe);

	categorie = new Button("Categorie");
	categorie.addActionListener(new ButtonOption("categorie"));
	p_option.add(categorie);
	
	entraineur = new Button("Entraineur");
	entraineur.addActionListener(new ButtonOption("entraineur"));
	p_option.add(entraineur);

	f.add(p_option);
    }

    void panelTextArea(){
	p_textarea = new Panel();
	textfield = new JTextField(20);
	p_textarea.add(textfield);
	f.add(p_textarea);
    }

    void panelStats(){

	p_stats = new Panel();
	p_stats.setLayout(new GridLayout(4,1));
	 
	b_moyenne_rencontre_date = new Button("Moyenne des points marqués par rencontre");
	p_stats.add(b_moyenne_rencontre_date);

	b_moyenne_debut_saison = new Button("Moyenne des points marqués depuis le début de la saison");
	p_stats.add(b_moyenne_debut_saison);

	b_class_joueurs = new Button("Classement des meilleurs joueurs d'une jourenée pour une catégorie");
	b_class_joueurs.addActionListener(new ButtonClassJoueur());
	p_stats.add(b_class_joueurs);
	
	b_class_equipes = new Button("Classement des équipes");
	b_class_equipes.addActionListener(new ButtonClassEquipe());
	p_stats.add(b_class_equipes);
    	
	f.add(p_stats); 

    }
    void panelExit(){
	p_exit = new Panel();

	b_update = new Button("Update");
	b_update.addActionListener(new ButtonUpdate());
	p_exit.add(b_update);
      
	b_exit = new Button("Exit");
	b_exit.addActionListener(new ButtonExit());
	p_exit.add(b_exit);
	
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