import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutDemo {
	
	private JFrame frame;
	private JLabel north, south, east, west, center;
	private JPanel np, sp, ep, wp, cp;
	
	public BorderLayoutDemo() {
		frame = new JFrame();
		frame.setTitle("Border Layout Demo");
		frame.setBounds(600, 300, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		north = new JLabel("North");
		south = new JLabel("South");
		east = new JLabel("East");
		west = new JLabel("West");
		center = new JLabel("Center");
		np = new JPanel();
		sp = new JPanel();
		ep = new JPanel();
		wp = new JPanel();
		cp = new JPanel();
		np.setBackground(Color.red);
		sp.setBackground(Color.GREEN);
		wp.setBackground(Color.CYAN);
		ep.setBackground(Color.PINK);
		cp.setBackground(Color.YELLOW);
		np.add(north);
		sp.add(south);
		wp.add(west);
		ep.add(east);
		cp.add(center);
		frame.setLayout(new BorderLayout());
		frame.add(np, BorderLayout.NORTH);
		frame.add(sp, BorderLayout.SOUTH);
		frame.add(wp, BorderLayout.WEST);
		frame.add(ep, BorderLayout.EAST);
		frame.add(cp, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new BorderLayoutDemo();

	}

}
