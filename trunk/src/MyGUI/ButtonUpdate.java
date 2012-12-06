import java.awt.*;
import java.awt.event.*;


class ButtonUpdate implements ActionListener{
    private Frame FrameUpdate;
    private Panel panel1Update,panel2Update,panel3Update;
    private Button buttonAdd, buttonDelete,buttonChange;
    private Button buttonYes, buttonNo;
    private TextArea ta_update;
    private String decide = "Add";
    private String info = "";
    public void actionPerformed(ActionEvent e)
    {
	
	FrameUpdate = new Frame("Update");
	FrameUpdate.setSize(400,300);
	panel1Update = new Panel();
	buttonAdd = new Button("Add");
	buttonAdd.addActionListener(new ButtonAdd());
	buttonDelete = new Button("Delete");
	buttonDelete.addActionListener(new ButtonDelete());
	buttonChange = new Button("Change");
	buttonChange.addActionListener(new ButtonChange());
	panel1Update.add(buttonAdd);
	panel1Update.add(buttonDelete);
	panel1Update.add(buttonChange);
	FrameUpdate.add(panel1Update, "North");
	panel2Update = new Panel();
	ta_update = new TextArea("Donnee",5,40);
	//ta_update.addTextListener(new TextAreaUpdate());
	panel2Update.add(ta_update);
	panel2Update.add(new Label("Are you sure?"),"Center");
	FrameUpdate.add(panel2Update);
	panel3Update = new Panel();
	buttonYes = new Button("Yes");
	buttonYes.addActionListener(new ButtonYes());
	buttonNo = new Button("No");
	buttonNo.addActionListener(new ButtonNo());
	panel3Update.add(buttonYes);
	panel3Update.add(buttonNo);
	FrameUpdate.add(panel3Update,"South");
	FrameUpdate.setVisible(true);
	System.out.println("Action Update");
    }
    // class TextAreaUpdate implements TextListener{
    // 	// public void textPerformed(TextEvent e){
    // 	//     info = ta_update.getText();
    // 	// }
    // }
    class ButtonAdd implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    decide = "Add";
	}
    } 
    class ButtonDelete implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    decide = "Delete";
	}
    } 
    class ButtonChange implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    decide = "Change";
	}
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