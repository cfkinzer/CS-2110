/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/** Items in the array being compared are highlighted in red
 * 
 * Questions:
 * 1. In this assignment, I used locks so that the GUI was in a consistent state as the threads accessed it. Basically, locking the GUI allowed the threads to safely access and change the GUI. 
 * 2. Waiting threads can be "woken up" by another thread calling signal() or signalAll() whereas a sleeping thread can only wait to "wake up"
 * 3. If the thread isn't signalled, it never resumes and the process dies.
 *  
 *  
 * */

public class SortViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 800;
		JLabel selection = new JLabel("Selection Sort");
		JLabel bubble = new JLabel("Bubble Sort");
		JLabel insertion = new JLabel("Insertion Sort");
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(6, 1));
		int[] array = ArrayUtil.makeArray();
		int[] array1 = new int[50];
		int[] array2 = new int[50];
		for (int i = 0; i < array.length; i++) {
			array1[i] = array[i];
			array2[i] = array[i];
		}
		final SelectionSortComponent component = new SelectionSortComponent(array);
		frame.add(selection);
		frame.add(component);
		final BubbleSortComponent component1 = new BubbleSortComponent(array1);
		frame.add(bubble);
		frame.add(component1);
		final InsertionSortComponent component2 = new InsertionSortComponent(array2);
		frame.add(insertion);
		frame.add(component2);
		
		frame.setVisible(true);
		component.startAnimation();
		component1.startAnimation();
		component2.startAnimation();
	}
}
