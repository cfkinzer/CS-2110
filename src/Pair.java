
public class Pair<T, E> {

	private T t;
	private E e;
	
	public Pair(T t, E e){
		this.t = t;
		this.e = e;
	}
	
	public String toString(){
		return "[First element in pair: " + t +
				", Second element in pair: " + e + "]";
	}
	
	public void setFirst(T t){
		this.t = t;
	}
	
	public void setSecond(E e){
		this.e = e;
	}
	
	public static void main(String[] args) {
		Pair<String, String> name = new Pair<String, String>("David", "Edwards");
		System.out.println(name);
		name.setFirst(6);

		Pair<Integer, Integer> point = new Pair<Integer, Integer>(5, 4);
		System.out.println(point);
		
		Pair<String, Integer> phoneBookEntry = new Pair<String, Integer>("Lucas", 9785555);
		System.out.println(phoneBookEntry);
	}

}
