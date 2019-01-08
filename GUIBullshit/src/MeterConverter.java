import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
   The MetricConverter class lets the user enter a
   distance in kilometers. Radio buttons can be selected to
   convert the kilometers to miles, feet, or inches.
*/

public class MeterConverter extends JFrame
{
   private JPanel panel;                  // A holding panel
   private JLabel messageLabel;           // A message to the user
   private JTextField meterTextField;      // To hold user input
   private JRadioButton yardsButton;      // To convert to miles
   private JRadioButton feetButton;       // To convert to feet
   private JRadioButton inchesButton;     // To convert to inches
   private ButtonGroup radioButtonGroup;  // To group radio buttons
   private final int WINDOW_WIDTH = 400;  // Window width
   private final int WINDOW_HEIGHT = 100; // Window height

   /**
      Constructor
   */

   public MeterConverter()
   {
      // Set the title.
      setTitle("Meter Converter");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Build the panel and add it to the frame.
      buildPanel();

      // Add the panel to the frame's content pane.
      add(panel);

      //Show in the middle of the screen.
      setLocationRelativeTo(null);
      
      // Display the window.
      setVisible(true);
   }

   /**
      The buildPanel method adds a label, text field, and
      and three buttons to a panel.
   */

   private void buildPanel()
   {
      // Create the label, text field, and radio buttons.
      messageLabel = new JLabel("Enter a distance in meters");
      meterTextField = new JTextField(10);
      yardsButton = new JRadioButton("Convert to yards");
      feetButton = new JRadioButton("Convert to feet");
      inchesButton = new JRadioButton("Convert to inches");

      // Group the radio buttons.
      radioButtonGroup = new ButtonGroup();
      radioButtonGroup.add(yardsButton);
      radioButtonGroup.add(feetButton);
      radioButtonGroup.add(inchesButton);

      // Add action listeners to the radio buttons.
      yardsButton.addActionListener(new RadioButtonListener());
      feetButton.addActionListener(new RadioButtonListener());
      inchesButton.addActionListener(new RadioButtonListener());

      // Create a panel and add the components to it.
      panel = new JPanel();
      panel.add(messageLabel);
      panel.add(meterTextField);
      panel.add(yardsButton);
      panel.add(feetButton);
      panel.add(inchesButton);
   }

   /**
      Private inner class that handles the event when
      the user clicks one of the radio buttons.
   */

   private class RadioButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String input;          // To hold the user's input
         String convertTo = ""; // The units we're converting to
         double result = 0.0;   // To hold the conversion

         // Get the meters entered.
         input = meterTextField.getText();
         
         if(input.equals("")) {
        	 radioButtonGroup.clearSelection();
        	 return;
         }
         if(e.getSource() == yardsButton) {
        	 convertTo = " yards.";
        	 result = Double.parseDouble(input) * 1.09;
         }
         else if(e.getSource() == feetButton) {
        	 convertTo = " feet.";
        	 result = Double.parseDouble(input) * 3.28;
         }
         else if(e.getSource() == inchesButton) {
        	 convertTo = " inches.";
        	 result = Double.parseDouble(input) * 39.37;
         }
         
         JOptionPane.showMessageDialog(null, input + " meters is " + result + convertTo);
         radioButtonGroup.clearSelection();
         
         
      }
   }
   
   /**
      The main method creates an instance of the
      MetricConverterWindow class, displaying its window.
   */
   
   public static void main(String[] args)
   {
      new MeterConverter();
   }
}
