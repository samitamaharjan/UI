package application;

import java.io.IOException;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;

public class SetupForLogin {

	public static void main(String[] args) throws IOException {
		FileManager<LibraryMember> loginManager = new FileManagerImpl<>("libraryMember");
		loginManager.clean();
		
		LibraryMember john = new LibraryMember("1051", "John", "Smith", "2589642", null);
		LibraryMember samita = new LibraryMember("1052", "Samita", "Maharjan", "2058651", null);
		
		loginManager.insert(john);
		loginManager.insert(samita);
		loginManager.print();
		
		System.out.println("=========================");
		
		samita.setFirstName("James");
		samita.setLastName("Singh");
		loginManager.edit(samita);
		loginManager.print();
	}
}
