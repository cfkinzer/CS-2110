/* Christian Kinzer
 * cfk5ax
 * HW3
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Hw3Test {

	@Test
	public void testCheckNumCopies1() { // testing number of copies of harry potter in library, expect 2
		Library l = new Library("Library");
		ArrayList<Book> books = new ArrayList<Book>();
		Book hp = new Book("Harry Potter", "JK Rowling", 69, 10);
		Book hp1 = new Book("Harry Potter", "JK Rowling", 70, 10);
		books.add(hp);
		books.add(hp1);
		l.setLibraryBooks(books);
		int copies = l.checkNumCopies("Harry Potter", "JK Rowling");
		assertTrue(copies == 2);
	}
	@Test
	public void testCheckNumCopies2() { // testing number of copies when there are no copies
		Library l = new Library("Library");
		int copies = l.checkNumCopies("The Bible", "Jesus");
		assertTrue(copies == 0);
	}
	@Test
	public void testCheckOut1() { // testing if checking out a book changes its due date
		Library l = new Library("Library");
		Person p = new Person("Name", "Address", 69);
		Book bible = new Book("The Bible", "Jesus", 1, 10);
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p);
		l.setPatrons(people);
		books.add(bible);
		l.setLibraryBooks(books);
		l.checkOut(p, bible, "12 12 2017");
		assertTrue(bible.getDueDate().equals("12 12 2017"));
	}
	@Test
	public void testCheckOut2() { // testing if checking out a book adds it to a person's checked out list
		Library l = new Library("Library");
		Person p = new Person("Name", "Address", 69);
		Book bible = new Book("The Bible", "Jesus", 1, 10);
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p);
		l.setPatrons(people);
		books.add(bible);
		l.setLibraryBooks(books);
		l.checkOut(p, bible, "12 12 2017");
		assertTrue(p.getCheckedOut().contains(bible));
	}
	@Test
	public void testBooksDueOnDate1() { // testing if this works when due dates are manually set
		Library l = new Library("Library");
		ArrayList<Book> books = new ArrayList<Book>();
		Book hp = new Book("Harry Potter", "JK Rowling", 69, 10);
		Book hp1 = new Book("Harry Potter", "JK Rowling", 70, 10);
		books.add(hp);
		books.add(hp1);
		l.setLibraryBooks(books);
		hp.setDueDate("12 12 2017");
		hp1.setDueDate("12 12 2017");
		assertTrue(l.booksDueOnDate("12 12 2017").size() == 2);
	}
	@Test
	public void testBooksDueOnDate2() { // testing if this works when there are no books
		Library l = new Library("Library");
		assertTrue(l.booksDueOnDate("12 12 2017").size() == 0);
	}
	@Test
	public void testLateFee1() { // testing a person with a book overdue by a day, expect .10
		Library l = new Library("Library");
		ArrayList<Book> books = new ArrayList<Book>();
		Book hp = new Book("Harry Potter", "JK Rowling", 69, 10);
		Book hp1 = new Book("Harry Potter", "JK Rowling", 70, 10);
		books.add(hp);
		books.add(hp1);
		Person p = new Person("Name", "Address", 69);
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p);
		l.setPatrons(people);
		l.setLibraryBooks(books);
		l.checkOut(p, hp, "12 12 2017");
		l.setCurrentDate("12 13 2017");
		double fee = l.lateFee(p);
		assertTrue(fee == .10);
	}
	@Test
	public void testLateFee2() { // testing with a person that hasn't checked out a book
		Library l = new Library("Library");
		Person p = new Person("Name", "Address", 69);
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p);
		l.setPatrons(people);
		double fee = l.lateFee(p);
		assertTrue(fee == 0);
	}
}
