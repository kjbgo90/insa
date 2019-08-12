package com.insa.vo;

public class SearchResultVo {
	private int sabun;
	private String name;
	private String reg_no;
	private String hp;
	private String pos_gbn_code;
	private String pos_name;
	private String join_day;
	private String retire_day;
	private String put_yn;
	private int salary;

	public SearchResultVo() {
	}

	public SearchResultVo(int sabun, String name, String reg_no, String hp, String pos_gbn_code, String pos_name,
			String join_day, String retire_day, String put_yn, int salary) {
		this.sabun = sabun;
		this.name = name;
		this.reg_no = reg_no;
		this.hp = hp;
		this.pos_gbn_code = pos_gbn_code;
		this.pos_name = pos_name;
		this.join_day = join_day;
		this.retire_day = retire_day;
		this.put_yn = put_yn;
		this.salary = salary;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getPhone() {
		return hp;
	}

	public void setPhone(String hp) {
		this.hp = hp;
	}

	public String getPos_gbn_code() {
		return pos_gbn_code;
	}

	public void setPos_gbn_code(String pos_gbn_code) {
		this.pos_gbn_code = pos_gbn_code;
	}

	public String getJoin_day() {
		return join_day;
	}

	public void setJoin_day(String join_day) {
		this.join_day = join_day;
	}

	public String getRetire_day() {
		return retire_day;
	}

	public void setRetire_day(String retire_day) {
		this.retire_day = retire_day;
	}

	public String getPut_yn() {
		return put_yn;
	}

	public void setPut_yn(String put_yn) {
		this.put_yn = put_yn;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPos_name() {
		return pos_name;
	}

	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	@Override
	public String toString() {
		return "SearchResultVo [sabun=" + sabun + ", name=" + name + ", reg_no=" + reg_no + ", hp=" + hp
				+ ", pos_gbn_code=" + pos_gbn_code + ", pos_name=" + pos_name + ", join_day=" + join_day
				+ ", retire_day=" + retire_day + ", put_yn=" + put_yn + ", salary=" + salary + "]";
	}

}
