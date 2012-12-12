import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn;  


public class MyFrame3 implements ActionListener{
    private static JFrame frame;
    private static Container content;
    private static JPanel panel1,panel2,panel3;
    private static JLabel labelnumero, labelname;
    private static JTextField textnumero, textname;
    private static JButton buttonadd, buttonclear,buttoncancel;

    public void go(){
	frame = new JFrame("GUI Basketball");
	frame.setLayout(new GridLayout(3,1));
	frame.setSize(400,200);
	frame.setLocationRelativeTo(null);
	frame.getContentPane().setBackground(Color.white);

	panel1 = new JPanel();
	labelnumero = new JLabel("Numero de categorie");
	textnumero = new JTextField("",20);
	panel1.add(labelnumero);
	panel1.add(textnumero);
	frame.add(panel1);
	
	panel2 = new JPanel();
	labelname = new JLabel("Date de rencontre");
	textname = new JTextField("",20);
	panel2.add(labelname);
	panel2.add(textname);
	frame.add(panel2);
	
	panel3 = new JPanel();
	buttonadd = new JButton("Find");
	buttonadd.addActionListener(this);
	panel3.add(buttonadd);
	buttonclear = new JButton("Clear");
	buttonclear.addActionListener(this);
	panel3.add(buttonclear);
	buttoncancel = new JButton("Cancel");
	buttoncancel.addActionListener(this);
	panel3.add(buttoncancel);
	frame.add(panel3);
	frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e){
	
	if(e.getActionCommand().equals("Cancel"))
	    frame.dispose();
	
	else if(e.getActionCommand().equals("Clear")){
	    textnumero.setText("");
		textname.setText("");    
	}
	else if(e.getActionCommand().equals("Find")){
	    //System.out.println("select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS from joueur, participe, rencontre where rencontre.date_rencontre > '" + textnumero.getText()+"'and rencontre.numero_rencontre = participe.numero_rencontre;");    
		System.out.println("select joueur.numero_licence, sum(participe.cumul_points_marques_joueur) as SCORE\n" +
		"from joueur, participe, rencontre, equipe\n"+
		"where equipe.numero_categorie = "+textnumero.getText()+ "\n"+
      	"and rencontre.date_rencontre = '"+textname.getText()+"'\n" +
	    "and equipe.numero_equipe = joueur.numero_equipe\n" +
      	"and joueur.numero_licence = participe.numero_licence\n" +
      	"and participe.numero_rencontre = rencontre.numero_rencontre" +
		"group by joueur.numero_licence\n" +
		"order by score DESC;");
		frame.dispose();	
	}
	else
	    this.go();
        
    }
    
 }
