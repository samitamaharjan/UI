package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import interfaces.PrimaryKey;

public class BookCopy implements Serializable, PrimaryKey {

	private static final long serialVersionUID = 5654380069068491357L;
	
	private String copybookid;
	private String noOfCopy;
	
	
	
	public BookCopy(String copybookid, String noOfCopy){
		
		this.copybookid = copybookid;
		this.noOfCopy = noOfCopy;
		
		
	}

	public String getCopyBookId() {
		return copybookid;
	}

	public String getNoOfCopy() {
		return noOfCopy;
	}

	

	@Override
	public String getPrimaryKey() {
		return copybookid;
	}
	
	
}
