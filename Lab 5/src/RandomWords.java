import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomWords {

	public static void main(String[] args) {
		ArrayList<Integer> keys = new ArrayList<Integer>();
		String[] words = generateRandomWords(1000);
		for(String s : words) {
			keys.add(hashFunction(s));
		}
		HashSet<Integer> set = new HashSet<Integer>(keys);
		int dupes = keys.size() - set.size();
		System.out.println(dupes);
	}

	//A static method that takes in the number or words you would like in your array of 
	//random words.  Each word is between 3 and 10 characters in length and contain only
	//lower case letters.  
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
	public static int hashFunction(String s) {
		int key = 7;
		for (int i = 0; i < s.length(); i++) {
		    key = key*31 + s.charAt(i);
		}
		return key;
	}
}
