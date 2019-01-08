/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class BubbleSorter { // most of the sorter classes were copied almost directly from the textbook, Big Java 22.6
	private int[] a;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private Lock sortStateLock;
	private JComponent component;
	private static final int DELAY = 70;

	public BubbleSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}

	public void bubbleSort() throws InterruptedException { // bubble sort algorithm found on http://www.geeksforgeeks.org/bubble-sort/
		int n = a.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				sortStateLock.lock();
				try {
					markedPosition = j;
					alreadySorted = j + 1;
					if (a[j] > a[j+1]) {
						// swap temp and arr[i]
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}	
				}
				finally {
				sortStateLock.unlock();
				}
				pause(2);
			}
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

