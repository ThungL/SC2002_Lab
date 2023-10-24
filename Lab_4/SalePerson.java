package lab4;

public class SalePerson implements Comparable{

	private String firstName;
	private String lastName;
	private int totalSales;
	
	public SalePerson(String firstName, String lastName, int totalSales) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalSales = totalSales;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public String toString() {
		String tSstring = Integer.toString(this.totalSales); 
		return this.lastName + ", " + this.firstName + " : " + tSstring;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
	        return true;
	    }
		if (o == null || getClass() != o.getClass()) {
	        return false;
	    }
		SalePerson otherSalePerson = (SalePerson) o;
		if (firstName.equals(otherSalePerson.firstName) && lastName.equals(otherSalePerson.lastName)) {
	        return true;
	    }

	    return false;
	}
	
	public int compareTo(Object o) {
		SalePerson otherSalePerson = (SalePerson) o;

	    // Compare based on total sales
	    int salesComparison = Integer.compare(totalSales, otherSalePerson.totalSales);

	    // If total sales are different, return the result
	    if (salesComparison != 0) {
	        return salesComparison;
	    }
	    
	    // If total sales are the same, compare based on last names
	    return otherSalePerson.lastName.compareTo(this.lastName);
	}
	
}
