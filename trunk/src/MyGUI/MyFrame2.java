import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultCellEditor;  
import javax.swing.table.TableColumn;  

public class MyFrame2 implements ActionListener{
    private static JFrame frame;
    private static Container content;
    private static JPanel panel1,panel2,panel3;
    private static JLabel labelnumero, labelname;
    private static JTextField textnumero, textname;
    private static JButton buttonadd, buttonclear,buttoncancel;
    private static String cmd;
    private EcritureFichier Ef = null;
    private String fichier;
    public MyFrame2(EcritureFichier f,String nf){
	this.Ef = f;
	this.fichier = nf;
    }

    public void go(){
	frame = new JFrame("GUI Basketball");
	frame.setLayout(new GridLayout(2,1));
	frame.setSize(400,100);
	frame.setLocationRelativeTo(null);
	frame.getContentPane().setBackground(Color.white);

	panel1 = new JPanel();
	labelnumero = new JLabel("Date de debut saison");
	textnumero = new JTextField("",20);
	panel1.add(labelnumero);
	panel1.add(textnumero);
	frame.add(panel1);
	
	
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
	
	else if(e.getActionCommand().equals("Clear"))
	    textnumero.setText("");

	else if(e.getActionCommand().equals("Find")){
	    cmd = 
		"select avg(participe.cumul_points_marques_joueur) as MOYENNE_POINTS\n"+
		"from joueur, participe, rencontre\n"+ 
		"where rencontre.date_rencontre > '" + textnumero.getText()+"' and rencontre.numero_rencontre = participe.numero_rencontre;";
	    Ef.ecrireDuTexte(cmd,fichier);
	    System.out.println(cmd);
	    frame.dispose();	
	}
	else
	    this.go();
        
    }
 }
