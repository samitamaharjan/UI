package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.project.interfaces.PrimaryKey;

public class CheckoutRecordEntry implements Serializable, PrimaryKey {

	private static final long serialVersionUID = 3212119783452653024L;
	
	private String id;
	private String item;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookcopy;

	public CheckoutRecordEntry(String item, LocalDate checkoutDate, LocalDate dueDate, BookCopy bookcopy) {
		this.id = UUID.randomUUID().toString();
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.bookcopy = bookcopy;
	}

	public String getItem() {
		return item;
	}

	public BookCopy getBookcopy() {
		return bookcopy;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public String getId() {
		return id;
	}

	@Override
	public String getPrimaryKey() {
		return id;
	}
}
