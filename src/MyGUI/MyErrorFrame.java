import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MyErrorFrame implements ActionListener{
    private JFrame errorFrame;
    private JPanel myPanel;
    private JButton buttonYes, buttonNo;
    public void go()
    {
	
	errorFrame = new JFrame("Error");
	errorFrame.setSize(400,300);
	errorFrame.setLocationRelativeTo(null);
	errorFrame.getContentPane().setBackground(Color.white);
	errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	errorFrame.add(new JLabel("Choose one of object at first!"));
	buttonYes = new JButton("Yes I know");
	buttonYes.addActionListener(this);
	buttonNo = new JButton("No");
	buttonNo.addActionListener(this);
	myPanel.add(buttonYes);
	myPanel.add(buttonNo);
	
	errorFrame.add(myPanel,"South");
	errorFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Yes I know"))
	    errorFrame.dispose();
    }
}