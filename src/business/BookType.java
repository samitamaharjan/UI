package business;

public enum BookType {
	REGULAR(21), REFERENCE(7);
	
	private int noOfDays;
	
	private BookType(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	@Override
	public String toString() {
		return String.valueOf(noOfDays);
	}
}
