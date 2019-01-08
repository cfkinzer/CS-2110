// Christian Kinzer
// cfk5ax
// HW3

public class Book {
	private String title;
	private String author;
	private String dueDate;
	private boolean checkedOut;
	private int bookId;
	private double bookValue;

	public Book(String book, String writer, int id, double value) { // constructor
		title = book;
		author = writer;
		dueDate = "00 00 0000";
		checkedOut = false;
		bookId = id;
		bookValue = value;
	}
	public String getTitle() { // getter for the title
		return this.title;
	}
	public String getAuthor() { // getter for the author
		return this.author;
	}
	public String getDueDate() { // getter for the due date
		return this.dueDate;
	}
	public boolean isCheckedOut() { // getter for the boolean checked out
		return this.checkedOut;
	}
	public int getBookId() { // getter for the book's ID
		return this.bookId;
	}
	public double getBookValue() { // getter for the book's value
		return this.bookValue;
	}
	public void setTitle(String s) { // setter for the book's title
		this.title = s;
	}
	public void setAuthor(String s) { // setter for the book's author
		this.author = s;
	}
	public void setDueDate(String s) { // setter for the book's due date
		this.dueDate = s;
	}
	public void setCheckedOut(boolean b) { // setter for the boolean checked out
		this.checkedOut = b;
	}
	public void setBookId(int i) { // setter for the book's ID
		this.bookId = i;
	}
	public void setBookValue(double d) { // setter for the book's value
		this.bookValue = d;
	}
	public boolean equals(Object o) { // equals method for books, books are equal if ID is the same
		if(o instanceof Book) {
			Book b = (Book)o;
			return (this.bookId == b.bookId);
		}
		else {
			return false;
		}
	}

	public String toString() { // formats a book as a string
		return this.title + ", by " + this.author;
	}
}
