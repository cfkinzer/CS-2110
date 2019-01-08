import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo {

	private JFrame frame;
	private JButton b1, b2, b3;
	
	public FlowLayoutDemo() {
		
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 300, 200, 200);
		b1 = new JButton("Button 1");
		b2 = new JButton("Button 2");
		b3 = new JButton("Button 3");
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlowLayoutDemo();

	}

}
