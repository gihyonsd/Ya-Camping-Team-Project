package vo;

public class member {
	private int user_num;
	private String id;
	private String passwd;
	private String name;
	private String nickname;
	private String phone;
	private String birth;
	private String email;
	private String address;
	private String gender;
	
	public member(int user_num, String id, String passwd, String name, String nickname, String phone, String birth, String email, String address, String gender) {
		super();
		this.user_num = user_num;
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.address = address;
		this.gender = gender;
	}
	
	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public member() {
		
	}


}
