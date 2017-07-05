package application;

import java.io.IOException;
import java.util.List;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;

public class TestApp {

	public static void main(String[] args) throws IOException {
		FileManager<LibraryMember> loginManager = new FileManagerImpl<>("libraryMember");
		loginManager.insert(new LibraryMember("1051", "John", "Smith", "2589642", null));
		
		List<LibraryMember> list = loginManager.findAll();
		
		for (LibraryMember l : list) {
			System.out.println(l);
		}
	}
}
