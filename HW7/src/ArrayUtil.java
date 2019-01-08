/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW7
 */

import java.util.Random;

public class ArrayUtil { // allows us to manipulate arrays
	
	public static void swap(int[] array, int b, int c) { // swaps two values' positions in an array
		int temp = array[b];
		array[b] = array[c];
		array[c] = temp;
	}
	
	public static int[] makeArray() { // makes an array of ints 1-50 in random order
		int[] values = new int[50]; // makes an empty array of size 50
		for (int i = 0; i < 50; i++) { // fills the array with 1 through 50
			values[i] = i + 1;
		}
		int index;
		Random random = new Random();
		for (int i = values.length - 1; i > 0; i--) { // Fisher-Yates shuffle (algorithm found on wikipedia)
			index = random.nextInt(i + 1);
			if (index != i) {
				values[index] ^= values[i];
				values[i] ^= values[index];
				values[index] ^= values[i];
			}
		}
		return values;
	}
}
