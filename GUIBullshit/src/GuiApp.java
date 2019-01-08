//CS2110: Small Swing GUI Demo - repeat the word(s) you type!
// Output written to a JTextField

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GuiApp {
	
	// let's put Swing components here as fields
	private JFrame frame;
	private JLabel nameLabel;
	private JTextField nameTF;
	private JButton submitBtn;
	private JTextField outputTF;
	
	// other fields are next

	// --------------------------------------------------- main() ---
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		GuiApp theApp = new GuiApp(); // our GUI application
	}


	// --------------------------------------------------- constructor ---
	public GuiApp() {
		// we could do other non-GUI work here if needed
		initialize(); // our method to setup the GUI
	}

	// --------------------------------------------------- initialize() ---
	private void initialize() {
		// first, do things to configure the JFrame (this object)
		frame = new JFrame();
		frame.setSize(400,150);
		frame.setTitle("Simple Swing Demo - Parrots what you type!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		// Now, create, configure and add GUI Components
		// #1: JLabel to label the input text-field
		nameLabel = new JLabel("Name:");
		frame.add(nameLabel);
		
		// #2: JTextField for input
		nameTF = new JTextField(20);
		frame.add(nameTF);
		//nameTF.addActionListener( new HandleSubmitPressed() );
		//HandleSubmitPressed --> see below. New class that implements ActionListener
		
		// #3: A button, which will need an event handler too
		submitBtn = new JButton("Submit");
		frame.add(submitBtn);
		submitBtn.addActionListener( new HandleSubmitPressed() );
		
		// #4: Another JTextField to write output into later
		outputTF = new JTextField(25);
		frame.add(outputTF);

		// Finally, more JFrame-level things to make it all work 
		//frame.pack();  // *** uncomment this to shrink frame around contents ***
		frame.setLocationRelativeTo(null);//opens the frame in the middle of the screen
		frame.setVisible(true); // necessary to start event-handling thread
	}
	
	private class HandleSubmitPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("I've been pressed!");
			String name = nameTF.getText().trim();
			outputTF.setText("you typed: " + name);
			nameTF.setText("");
		}
		
	}
	
	
}
