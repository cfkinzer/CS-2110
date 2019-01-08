import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo {

	private JFrame frame;
	private JButton b1, b2, b3, b4, b5, b6;
	
	public GridLayoutDemo() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grid Layout Demo");
		frame.setLayout(new GridLayout(2,3));
		frame.setBounds(600, 300, 400, 200);
		b1 = new JButton("Button 1");
		b2 = new JButton("Button 2");
		b3 = new JButton("Button 3");
		b4 = new JButton("Button 4");
		b5 = new JButton("Button 5");
		b6 = new JButton("Button 6");
		frame.add(b1);
		frame.add(b5);
		frame.add(b3);
		frame.add(b4);
		frame.add(b2);
		frame.add(b6);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutDemo();

	}

}
