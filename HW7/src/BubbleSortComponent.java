/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.awt.Graphics;

import javax.swing.JComponent;

public class BubbleSortComponent extends JComponent { // most of the component classes are copied almost directly from the textbook, Big Java 22.6
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BubbleSorter sorter;
	private int[] anArray;
	
	public BubbleSortComponent(int[] a) {
		anArray = a;
		sorter = new BubbleSorter(anArray, this);
	}
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}
	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					sorter.bubbleSort();
				}
				catch (InterruptedException exception) {}
			}
		}
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}
