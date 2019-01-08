
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("Hello World!"));//should be "!dlroW olleH"
		System.out.println(reverseString("a"));//should be "a"
		System.out.println(reverseString(""));//should be ""
	}

	public static String reverseString(String s) {
		String t = "";
		for(int i = 0; i < s.length(); i++) {
			t = s.charAt(i) + t;
		}
		
		return t;
		
	}


}
