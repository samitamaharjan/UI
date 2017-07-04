package business;

import java.io.Serializable;

import com.project.interfaces.PrimaryKey;

public class Person implements Serializable, PrimaryKey {
	
	private static final long serialVersionUID = -1161938047579074731L;
	
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	private Address address;
	
	public Person(String memberId, String firstName, String lastName, String phone, Address address) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public String getMemberId() {
		return memberId;
	}

	@Override
	public String getPrimaryKey() {
		return memberId;
	}
}
