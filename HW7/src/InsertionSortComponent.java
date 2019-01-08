/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.awt.Graphics;

import javax.swing.JComponent;

public class InsertionSortComponent extends JComponent { // most of the component classes were copied almost directly from the texbook, Big Java 22.6
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InsertionSorter sorter;
	private int[] anArray;
	
	public InsertionSortComponent(int[] a) {
		anArray = a;
		sorter = new InsertionSorter(anArray, this);
	}
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}
	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					sorter.insertionSort();
				}
				catch (InterruptedException exception) {}
			}
		}
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}
