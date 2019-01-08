
public class IterRecurse {
	public int factorial(int n) {
		if (n <= 1){
			return 1;
		}
		else{
			return n * factorial(n-1);
		}
	}
	public int iterfact(int n) {
		int ans = 1;
		for (int i = 1; i <= n; i++) {
			ans *= i;
		}
		return ans;
	}
	public int bunnyEars(int bunnies) {
		if (bunnies == 1){
			return 2;
		}
		if (bunnies > 1){
			return 2+bunnyEars(bunnies-1);
		}
		else{
			return 0;
		}
	}
	public int iterbunny(int n) {
		return n * 2;
	}
	public static int fibonacci(int n) {
		if (n == 0){
			return 0;
		}
		if (n == 1){
			return 1;
		}
		if (n > 1){
			return fibonacci(n-1)+fibonacci(n-2);
		}
		else{
			return 0;
		}
	}
	public int iterfibonacci(int n) {
		int x;
		int y;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			x = i-1;
			y = i-2;
			ans = x + y;
		}
		return ans;
	}
	public int strCount(String str, String sub) {
		int sLen = sub.length();
		if(str.length() < sLen)
			return 0;
		if(str.substring(0, sLen).equals(sub))
			return 1 + strCount(str.substring(sLen), sub);
		return strCount(str.substring(1), sub);
	}
	public int iterstrCount(String str, String sub) {
		int sLen = sub.length();
		if(str.length() < sLen)
			return 0;
		if(str.substring(0, sLen).equals(sub))
			return 1 + strCount(str.substring(sLen), sub);
		return strCount(str.substring(1), sub);
	}
	public boolean groupSum(int start, int[] nums, int target) {
		if(target == 0)
			return true;
		if(start == nums.length)
			return false;
		if(groupSum(start + 1, nums, target - nums[start]))
			return true;
		return groupSum(start + 1, nums, target);
	}
	public boolean itergroupSum(int start, int[] nums, int target) {
		if(target == 0)
			return true;
		if(start == nums.length)
			return false;
		if(groupSum(start + 1, nums, target - nums[start]))
			return true;
		return groupSum(start + 1, nums, target);
	}
	public boolean groupSumClump(int start, int[] nums, int target) {
		if(start >= nums.length)
		{
			if(target == 0)
				return true;
			return false;
		}
		int i = start + 1;
		for(;  i < nums.length && nums[start] == nums[i]; i++);
		if(groupSumClump(i, nums, target - ((i - start) * nums[start])))
			return true;
		return groupSumClump(i, nums, target);
	}
	public boolean itergroupSumClump(int start, int[] nums, int target) {
		if(start >= nums.length)
		{
			if(target == 0)
				return true;
			return false;
		}
		int i = start + 1;
		for(;  i < nums.length && nums[start] == nums[i]; i++);
		if(groupSumClump(i, nums, target - ((i - start) * nums[start])))
			return true;
		return groupSumClump(i, nums, target);
	}
	public boolean splitArray(int[] nums) {
		return sidesAreEqual(nums, 0, 0);	}

	// recursive helper method
	public boolean sidesAreEqual(int[] nums, int i, int balance) {
		if(i == nums.length)
			return (balance == 0);
		if(sidesAreEqual(nums, i + 1, balance + nums[i]))
			return true;
		return sidesAreEqual(nums, i + 1, balance - nums[i]);
	}
	public boolean itersplitArray(int[] nums) {
		return sidesAreEqual(nums, 0, 0);	}

	// recursive helper method
	public boolean itersidesAreEqual(int[] nums, int i, int balance) {
		if(i == nums.length)
			return (balance == 0);
		if(sidesAreEqual(nums, i + 1, balance + nums[i]))
			return true;
		return sidesAreEqual(nums, i + 1, balance - nums[i]);
	}
	
	/** moving to activity 1 */
	
	public static int alternativeFibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		else if (!(n % 2 == 0)) {
			return (int) ((int) Math.pow(alternativeFibonacci((n+1)/2),2) + Math.pow(alternativeFibonacci((n-1)/2), 2));
		}
		else if(n % 2 == 0) {
			return (int) ((int) Math.pow(alternativeFibonacci((n/2)+1), 2) - Math.pow(alternativeFibonacci((n/2)-1),2));
		}
		else { return 0;}
	}
	public static void main(String[] args) {
		System.out.println(alternativeFibonacci(49));
		System.out.println(fibonacci(49));
	}
}


