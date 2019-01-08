/* Christian Kinzer
 * cfk5ax
 * HW3
 * https://stackoverflow.com/questions/3526485/how-do-you-subtract-dates-in-java#3526511
 * ^ used the above page to find out how to subtract dates for lateFee
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Library {
	private ArrayList<Book> libraryBooks;
	private ArrayList<Person> patrons;
	private String name;
	private int numBooks;
	private int numPeople;
	private String currentDate;

	public Library(String s) { // constructor
		libraryBooks = new ArrayList<Book>();
		patrons = new ArrayList<Person>();
		name = s;
		numBooks = libraryBooks.size();
		numPeople = patrons.size();
		currentDate = "00 00 0000";
	}
	public ArrayList<Book> getLibraryBooks(){ // getter for the list of books in the library
		return this.libraryBooks;
	}
	public ArrayList<Person> getPatrons(){ // getter for the list of patrons of the library
		return this.patrons;
	}
	public String getName() { // getter for the name of the library
		return this.name;
	}
	public int getNumBooks() { // getter for the number of books in the library
		int count = 0;
		for(Book b : this.libraryBooks) {
			if(!b.isCheckedOut()) {
				count += 1;
			}
		}
		return count;
	}
	public int getNumPeople() { // getter for the number of patrons in a library
		return this.patrons.size();
	}
	public String getCurrentDate() { // getter for the current date
		return this.currentDate;
	}
	public void setLibraryBooks(ArrayList<Book> b) { // setter for the list of books in the library
		this.libraryBooks = b;
		this.numBooks = this.libraryBooks.size();
	}
	public void setPatrons(ArrayList<Person> p) { // setter for the list of patrons in the library
		this.patrons = p;
		this.numPeople = patrons.size();
	}
	public void setName(String s) { // setter for the name of the library
		this.name = s;
	}
	public void setCurrentDate(String s) { // setter for the current date
		this.currentDate = s;
	}
	public int checkNumCopies(String title, String author) { // checks how many copies of a book the library has
		ArrayList<Book> copies = new ArrayList<Book>(); 
		for(Book b : this.libraryBooks) {
			if(b.getTitle().equals(title) && b.getAuthor().equals(author)) {
				copies.add(b);
			}
		}
		return copies.size();
	}
	public int totalNumBooks() { // returns an int of how many books the library owns
		return this.libraryBooks.size();
	}
	public boolean checkOut(Person p, Book b, String dueDate) { // checks a book out to a patron
		ArrayList<Book> theBook = new ArrayList<Book>();
		if(this.patrons.contains(p)) {
			if(checkNumCopies(b.getTitle(), b.getAuthor()) > 0) {
				if(!b.isCheckedOut()) {
					while(theBook.size() < 1) {
						for(Book x : this.libraryBooks) {
							if(x.getTitle().equals(b.getTitle()) && x.getAuthor().equals(b.getAuthor())) {
								x.setCheckedOut(true);
								x.setDueDate(dueDate);
								p.addBook(x);
								theBook.add(x);
								this.numBooks -= 1;
								return true;
							}
						}
					}
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		return false;
	}
	public ArrayList<Book> booksDueOnDate(String date){ // says how many books are due on a given date
		ArrayList<Book> books = new ArrayList<Book>();
		for(Book b : this.libraryBooks) {
			if(b.getDueDate().equals(date)) {
				books.add(b);
			}
		}
		return books;
	}
	public double lateFee(Person p) { // calculates the late fee for a patron
		double fee = 0;
		int currentYear = Integer.parseInt(this.currentDate.substring(6, 10));
		int currentMonth = Integer.parseInt(this.currentDate.substring(0, 2));
		int currentDay = Integer.parseInt(this.currentDate.substring(3, 5));
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(currentYear, currentMonth, currentDay);
		for(Book b : p.getCheckedOut()) {
			int dueYear = Integer.parseInt(b.getDueDate().substring(6, 10));
			int dueMonth = Integer.parseInt(b.getDueDate().substring(0, 2));
			int dueDay = Integer.parseInt(b.getDueDate().substring(3, 5));
			GregorianCalendar duedate = new GregorianCalendar();
			duedate.set(dueYear, dueMonth, dueDay);
			long span = calendar.getTimeInMillis() - duedate.getTimeInMillis();
			if(span > 0) {
				GregorianCalendar between = new GregorianCalendar();
				between.setTimeInMillis(span);
				long msInADay = 1000 * 60 * 60 * 24;
				int days = (int) (between.getTimeInMillis() / msInADay);
				fee += days * b.getBookValue() / 100;
			}
		}
		return fee;
	}
}
