package dto;

public class MemberDto {
	private String id,name,password,job,
				   tell_1,tell_2,tell_3,
				   mobile,email,reg_date;

	public MemberDto(String id, String name, String password, String job, String tell_1, String tell_2, String tell_3,
			String mobile, String email, String reg_date) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.job = job;
		this.tell_1 = tell_1;
		this.tell_2 = tell_2;
		this.tell_3 = tell_3;
		this.mobile = mobile;
		this.email = email;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getJob() {
		return job;
	}

	public String getTell_1() {
		return tell_1;
	}

	public String getTell_2() {
		return tell_2;
	}

	public String getTell_3() {
		return tell_3;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getReg_date() {
		return reg_date;
	}
	
}
