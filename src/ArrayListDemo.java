import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Bill");
		list.add("Sarah");
		list.add("Jan");
		
		list.add(1, "Will");
		list.set(1,"David");
		
		list.remove(2);
		list.remove("David");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.indexOf("Jan"));
		
		System.out.println(list.contains("Bill"));
		System.out.println(list.contains("David"));
		
		String[] names = new String[3];
		names[0] = "Lisa";
		names[1] = "Lucas";
		names[2] = "Zach";
		
		System.out.println(Arrays.toString(names));
		System.out.println(list);
		
		int[][] nums = new int[2][2];
		nums[0][0] = 5;
		
		ArrayList<ArrayList<?>> newList = new ArrayList<ArrayList<?>>();
		
		newList.add(list);
		ArrayList<Double> doublelist = new ArrayList<Double>();
		
		doublelist.add(3.5);
		doublelist.add(3.14159);
		
		newList.add(doublelist);
		
	}

}
