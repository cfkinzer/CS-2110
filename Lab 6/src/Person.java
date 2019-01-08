
public class Person implements Comparable<Person> {
	protected String name;
	protected String homeAddress;
	
	public Person(String name, String address) {
        this.name = name;
		this.homeAddress = address;
	}

	// NOTE: Best practice to include a default constructor in superclasses
	public Person() {
		this.name = "?";
		this.homeAddress = "?";
	}

	public String getMailingAddress() {
		return homeAddress;
	}
	
	public String toString() {
		return "{Person: name=" + name + ", homeAddress=" + homeAddress + "|";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return homeAddress;
	}

	public void setAddress(String address) {
		this.homeAddress = address;
	}

	public static void main(String[] args) {
		Person p1 = new Person("p1", "addr1");
		System.out.println(p1);
	}
	public int compareTo(Person p) {
		int retVal = 0;
		retVal = this.getName().compareTo(p.getName());
		if (retVal == 0) {
			retVal = this.getAddress().compareTo(p.getAddress());
		}
		return retVal;
	}
}
