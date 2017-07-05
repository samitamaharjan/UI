package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import interfaces.PrimaryKey;

public class CheckoutRecord implements Serializable, PrimaryKey {

	private static final long serialVersionUID = -3745534127313575440L;
	
	private String id;
	private List<CheckoutRecordEntry> entry;
	private LibraryMember member;

	public CheckoutRecord(CheckoutRecordEntry e) {
		this.id = UUID.randomUUID().toString();
		this.entry = new ArrayList<CheckoutRecordEntry>();
	}

	public LibraryMember getMember() {
		return member;
	}

	public List<CheckoutRecordEntry> getEntry() {
		return entry;
	}

	public void addEntry(CheckoutRecordEntry e) {
		entry.add(e);
	}

	public String getId() {
		return id;
	}

	@Override
	public String getPrimaryKey() {
		return id;
	}
}
