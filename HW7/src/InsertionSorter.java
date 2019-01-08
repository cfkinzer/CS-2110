/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class InsertionSorter { // most of the sorter classes were copied almost directly from the textbook, Big Java 22.6
	private int[] a;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private Lock sortStateLock;
	private JComponent component;
	private static final int DELAY = 70;
	
	public InsertionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}
	
	public void insertionSort() throws InterruptedException { // insertion sort algorithm found on http://www.geeksforgeeks.org/insertion-sort/
		int n = a.length;
        for (int i=1; i<n; ++i) {
        	sortStateLock.lock();
            int key = a[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            try {
            	while (j>=0 && a[j] > key) {
            		
            		a[j+1] = a[j];
            		j = j-1;
            		markedPosition = j;
            		alreadySorted = key;
            	}
            	a[j+1] = key;
            }
            finally {
            	sortStateLock.unlock();
            }
            pause(2);
        }
	}
	public void draw(Graphics g) {
		sortStateLock.lock();
		try {
			int deltaX = component.getWidth() / a.length;
			for (int i = 0; i < a.length; i++) {
				if (i == markedPosition) {
					g.setColor(Color.RED);
				}
				else if (i == alreadySorted) {
					g.setColor(Color.RED);
				}
				else {
					g.setColor(Color.BLACK);
				}
				g.fillRect(i * deltaX, 0, 4, a[i]);
			}
		}
		finally {
			sortStateLock.unlock();
		}
	}
	public void pause(int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(steps * DELAY);
	}
}
