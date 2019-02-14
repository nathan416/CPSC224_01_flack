import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class latinTranslator extends JFrame
{
	private JPanel panel;
	private JRadioButton Sinister;
	private JRadioButton Dexter;
	private JRadioButton Medium;
	private final int WINDOW_WIDTH = 310;  // Window width
    private final int WINDOW_HEIGHT = 100; // Window height
	private ButtonGroup radioButtonGroup;

	public latinTranslator()
	{
	   // Set the title.
	   setTitle("Latin Translator");

	   // Set the size of the window.
	   setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	   // Specify an action for the close button.
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   // Build the panel and add it to the frame.
	   buildPanel();

	   // Add the panel to the frame's content pane.
	   add(panel);

	   // Display the window.
	   setVisible(true);
	}

	private void buildPanel()
	{
	   // Create the label, text field, and radio buttons.
	   Sinister = new JRadioButton("Sinister");
	   Dexter = new JRadioButton("Dexter");
	   Medium = new JRadioButton("Medium");

	   // Group the radio buttons.
	   radioButtonGroup = new ButtonGroup();
	   radioButtonGroup.add(Sinister);
	   radioButtonGroup.add(Dexter);
	   radioButtonGroup.add(Medium);

	   radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(Sinister);
		radioButtonGroup.add(Dexter);
		radioButtonGroup.add(Medium);
	   // Add action listeners to the radio buttons.
	   Sinister.addActionListener(new RadioButtonListener());
	   Dexter.addActionListener(new RadioButtonListener());
	   Medium.addActionListener(new RadioButtonListener());

	   // Create a panel and add the components to it.
	   panel = new JPanel();
	   panel.add(Sinister);
	   panel.add(Medium);
	   panel.add(Dexter);  
	}

	private class RadioButtonListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
		  String result;
          // Get the kilometers entered.
          // Determine which radio button was clicked.
          if (e.getSource() == Sinister)
          {
			  result = "Left";
			  JOptionPane.showMessageDialog(null, result);
          }
          else if (e.getSource() == Dexter)
          {
			  result = "Right";
			  JOptionPane.showMessageDialog(null, result);
          }
          else if (e.getSource() == Medium)
          {
			  result = "Middle";
			  JOptionPane.showMessageDialog(null, result);
          }
       }
    }
	public static void main(String[] args)
   	{
      	new latinTranslator();
   	}
}
