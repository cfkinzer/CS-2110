/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.awt.Graphics;

import javax.swing.JComponent;

public class SelectionSortComponent extends JComponent { // copied almost entirely from Big Java 22.6
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SelectionSorter sorter;
	private int[] anArray;
	
	public SelectionSortComponent(int[] a) {
		anArray = a;
		sorter = new SelectionSorter(anArray, this);
	}
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}
	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					sorter.selectionSort();
				}
				catch (InterruptedException exception) {}
			}
		}
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}
