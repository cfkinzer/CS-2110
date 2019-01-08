//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

// -- Fruits and Vegetables GUI example --

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIApp1 {
    
    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {
        
        new GUIApp1();
    }

    public GUIApp1()
    {
        JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Switching Between Panels");
        guiFrame.setSize(300,250);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        //Options for the JComboBox ("Drop down menu")
        String[] fruitOptions = {"Apple", "Apricot", "Banana"
                ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"};
        
        //Options for the JList
        String[] vegOptions = {"Asparagus", "Beans", "Broccoli", "Cabbage"
                , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom"
                , "Pepper", "Radish", "Shallot", "Spinach", "Swede"
                , "Turnip"};
        
        // ........................................................... first panel ......................
        //The first JPanel contains a JLabel and JCombobox
        final JPanel comboPanel = new JPanel(); //create new JPanel "comboPanel"
        // ---- VISIBILITY DEFAULTS TO TRUE ----
        JLabel comboLbl = new JLabel("Fruits:"); //label
        JComboBox<String> fruits = new JComboBox<String>(fruitOptions);
        comboPanel.setVisible(false);//not showing this one first
        
        comboPanel.add(comboLbl); //add to comboPanel the label ("Fruits:")
        comboPanel.add(fruits);   //add to comboPanel the combobox
        
        // ........................................................... second panel .....................
        //Create the second JPanel. Add a JLabel and JList and
        //make use the JPanel is not visible.
        final JPanel listPanel = new JPanel(); //create new JPanel "listPanel"
        //listPanel.setVisible(false); // don't want it to show at first ---- VISIBILITY SET TO FALSE ----
        JLabel listLbl = new JLabel("Vegetables:"); //label
        JList<String> vegs = new JList<String>(vegOptions);
        vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP); //wrap text on panel
          
        listPanel.add(listLbl); //add to listPanel the label ("Vegetables:")
        listPanel.add(vegs);    //add to listPanel the list
        
        JButton vegFruitBut = new JButton( "Fruit or Veg"); //include the "Fruit or Veg" button at the bottom
        
        // ..............................................................................................

        //Create a panel that will display select of a vegie in a text box.
        JTextField text = new JTextField(20);
        JPanel p = new JPanel();
        JButton button = new JButton("Select Vegie");
        p.add(text);
        p.add(button);
        //Display this panel only when the Vegie panel is being displayed.  
        p.setVisible(listPanel.isVisible());
        //The ActionListener class is used to handle the
        //event that happens when the user clicks the button.
        //As there is not a lot that needs to happen we can 
        //define an anonymous inner class to make the code simpler.
        vegFruitBut.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
            	//When the fruit or veg button is pressed
            	//the setVisible value of the listPanel and
            	//comboPanel is switched from true to 
            	//false or vice versa.
            	listPanel.setVisible(!listPanel.isVisible());
            	comboPanel.setVisible(!comboPanel.isVisible());
            	p.setVisible(!p.isVisible());
            	// Note the use of negation to achieve this
            	
            }
        });
        
        //The JFrame uses the BorderLayout layout manager.
        //Put the two JPanels and JButton in different areas.
        guiFrame.add(comboPanel, BorderLayout.NORTH); // "top"
        guiFrame.add(listPanel, BorderLayout.CENTER); // "middle"
        guiFrame.add(vegFruitBut,BorderLayout.SOUTH); // "bottom"
        guiFrame.add(p, BorderLayout.WEST);//"left"
        
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(vegs.getSelectedValue());
				vegs.clearSelection();
			}
        	
        });
        
        
        guiFrame.pack();
        //make sure the JFrame is visible
        guiFrame.setVisible(true); //the JFrame is set to visible
    }
    
}

