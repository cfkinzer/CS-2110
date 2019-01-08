
public class MaxMin {

	
	public static void main(String[] args) 
	{
		int[] values = {19, 12, 13, 14, 17, 18, 16, 14, 11};
		int[] maxMinResults = maxMin(values, 0, values.length - 1);
		System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
	}

	/*  maxMin() -- return an array containing the minimum and maximum values of the input array.
	 * 	@param list: an array of ints as input
	 * 	@param first: the first index of the list (for recursion)
	 * 	@param last: the last index of the list (for recursion)
	 * 	
	 * 	Identify a base case, and work it out so that the array returns the min and max values.
	 * 	
	 * 	Then, identify what the method does to recursively arrive at the base case.
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	public static int[] maxMin(int[] list, int first, int last)
	{
		int[] ans = new int[2];
		ans[0] = findMin(list, first);
		ans[1] = findMax(list, first);
		return ans;
	}
	public static int findMax(int[] a, int index) {
		if (index > 0) {
			return Math.max(a[index], findMax(a, index-1));
		}
		else {
			return a[0];
		}
	}
	public static int findMin(int[] a, int index) {
		if (index == a.length -1) {
			return a[index];
		}
		int val = findMin(a, index + 1);
		if (a[index] < val) {
			return a[index];
		}
		else {
			return val;
		}
	}
}
