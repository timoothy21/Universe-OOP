package code;

public class Account {
	private String fullName, username, email, password, role;
	private int ID;
	
	public Account(int ID, String fullname, String username, String email, String password, String role) {
		this.fullName = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.ID = ID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}

	public void setID (int ID) {
		this.ID = ID;
	}
	
	
}
