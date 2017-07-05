package business;

import java.io.Serializable;

import interfaces.PrimaryKey;

public class BookCopy implements Serializable, PrimaryKey {

	private static final long serialVersionUID = 5654380069068491357L;
	
	private String copybookid;
	private int noOfCopy;
		
	public BookCopy(String copybookid, int noOfCopy){
		this.copybookid = copybookid;
		this.noOfCopy = noOfCopy;
	}

	public String getCopyBookId() {
		return copybookid;
	}

	public int getNoOfCopy() {
		return noOfCopy;
	}
	
	@Override
	public String getPrimaryKey() {
		return copybookid;
	}
	
	@Override
	public String toString() {
		return "BookCopy [copybookid=" + copybookid + ", noOfCopy=" + noOfCopy + "]";
	}
}
