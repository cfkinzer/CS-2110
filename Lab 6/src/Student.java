
public class Student extends Person {
	private String campusAddress;
	private double gpa;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campusAddress == null) ? 0 : campusAddress.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (campusAddress == null) {
			if (other.campusAddress != null)
				return false;
		} else if (!campusAddress.equals(other.campusAddress))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		return true;
	}

	public Student() {
		campusAddress = "";
		gpa = 0.0;
	}
	
	public String getCampusAddress() {
		return campusAddress;
	}

	public void setCampusAddress(String campusAddress) {
		this.campusAddress = campusAddress;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
}
