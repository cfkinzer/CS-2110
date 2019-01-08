// Christian Kinzer
// cfk5ax
// HW3

import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Book> checkedOut;
	private String address;
	private int libraryCardNum;

	public Person(String nombre, String addy, int num) { //constructor
		name = nombre;
		libraryCardNum = num;
		checkedOut = new ArrayList<Book>();
		address = addy;
	}
	public String getName() { //getter for name
		return this.name;
	}
	public String getAddress() { //getter for address
		return this.address;
	}
	public int getLibraryCardNum() { //getter for library card number
		int num = this.libraryCardNum;
		return num;
	}
	public ArrayList<Book> getCheckedOut(){ //getter for books checked out
		return this.checkedOut;
	}
	public void setAddress(String addy) { //setter for address
		this.address = addy;
	}
	public void setName(String s) { // setter for name
		this.name = s;
	}
	public boolean hasCheckedOut(Book b) { //checks if someone has checked out a book
		if(this.checkedOut.contains(b)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean addBook(Book b) { //adds a book to someone's checked out list
		if(!this.checkedOut.contains(b)) {
			this.checkedOut.add(b);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean returnBook(Book b) { //removes a book from someone's checked out list
		if(this.checkedOut.contains(b)) {
			this.checkedOut.remove(b);
			return true;
		}
		else {
			return false;
		}
	}

	public int numBooksCheckedOut() { //returns number of books in one's checked out list
		return this.checkedOut.size();
	}

	public boolean equals(Object o) { //checks if two people have the same library card number
		if(o instanceof Person) {
			Person p = (Person)o;
			int num = this.libraryCardNum;
			return num == p.libraryCardNum;
		}
		else {
			return false;
		}
	}

	public String toString() { //returns a string of a person, their name, and their read books
		String booksOut = this.checkedOut.toString();
		return this.name + " (" + this.libraryCardNum + ")" + ", from " + "address" + ", has checked out the following books: " + booksOut;
	}

	public static ArrayList<Book> commonBooks(Person a, Person b){ //returns a list of books two people have both checked out
		ArrayList<Book> inCommon = new ArrayList<Book>();
		for(Book i : a.checkedOut) {
			if(b.checkedOut.contains(i)) {
				inCommon.add(i);
			}
		}
		return inCommon;
	}

	public static double similarity(Person a, Person b) { //returns a similarity rating for two people's checked out list
		double denom = 1;
		if(a.checkedOut.size() <= b.checkedOut.size()) {
			denom = a.checkedOut.size();
		}
		if(b.checkedOut.size() < a.checkedOut.size()) {
			denom = b.checkedOut.size();
		}
		ArrayList<Book> common = commonBooks(a, b);
		double num = common.size();
		return num / denom;
	}

}
