import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class ButtonAdd implements ActionListener{
    private JFrame FrameUpdate;
    private Panel panel1Update,panel2Update,panel3Update;
    private JButton buttonAdd, buttonDelete,buttonChange;
    private JButton buttonYes, buttonNo;
    private TextArea ta_update;
    private JTable table;
    private String decide = "Add";
    private String info = "";
    public void actionPerformed(ActionEvent e)
    {
	//System.out.println(super.option);
	    go();
	
    }

    public void go(){
	FrameUpdate = new JFrame("Update");
	FrameUpdate.setSize(400,300);
	FrameUpdate.setLocationRelativeTo(null);
	FrameUpdate.getContentPane().setBackground(Color.white);
	FrameUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// panel1Update = new Panel();
	// buttonAdd = new JButton("Add");
	// buttonAdd.addActionListener(new ButtonAdd());
	// buttonDelete = new JButton("Delete");
	// buttonDelete.addActionListener(new ButtonDelete());
	// buttonChange = new JButton("Change");
	// buttonChange.addActionListener(new ButtonChange());
	// panel1Update.add(buttonAdd);
	// panel1Update.add(buttonDelete);
	// panel1Update.add(buttonChange);
	// FrameUpdate.add(panel1Update, "North");

	panel2Update = new Panel();
	ta_update = new TextArea("Donnee",5,40);
	//ta_update.addTextListener(new TextAreaUpdate());
	panel2Update.add(ta_update);
	panel2Update.add(new Label("Are you sure?"),"Center");
	FrameUpdate.add(panel2Update);
	panel3Update = new Panel();
	buttonYes = new JButton("Yes");
	buttonYes.addActionListener(new ButtonYes());
	buttonNo = new JButton("No");
	buttonNo.addActionListener(new ButtonNo());
	panel3Update.add(buttonYes);
	panel3Update.add(buttonNo);
	FrameUpdate.add(panel3Update,"South");
	FrameUpdate.setVisible(true);
	System.out.println("Action Update");
    }

    class ButtonYes implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    System.out.print(info);
	    System.out.print(decide);
	    System.out.println("\tI choose yes");
	    FrameUpdate.dispose();
	}
    }
    class ButtonNo implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    System.out.println("\tI choose no");
	    FrameUpdate.dispose();
	}
    }
}