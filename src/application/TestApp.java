package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import business.LibraryMember;
import business.LoginMember;
import managers.FileManager;
import managers.FileManagerImpl;

public class TestApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		List<LibraryMember> list = new ArrayList<>();
		
		FileManager<LibraryMember> loginFile = new FileManagerImpl<>("libraryMember");
		
		//loginFile.insert(new LoginMember("3001", "admin"));
		
		try (ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream("libraryMember"))) {
			list = (List<LibraryMember>) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		for (LibraryMember l : list) {
			System.out.println(l.getFirstName() + " " + l.getLastName());
		}
	}

}
