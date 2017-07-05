package business;

import java.io.Serializable;

import interfaces.PrimaryKey;

public class LoginMember implements Serializable, PrimaryKey {
	
	private static final long serialVersionUID = 2347249110147845254L;

	String userId;
	private String password;
	
	public LoginMember(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getPrimaryKey() {
		return userId;
	}
}
