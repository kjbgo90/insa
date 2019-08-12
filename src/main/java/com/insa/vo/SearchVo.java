package com.insa.vo;

public class SearchVo {
	private int sabun;
	private String name;
	private String join_gbn_code;
	private String put_yn;
	private String pos_gbn_code;
	private String join_day;
	private String retire_day;
	private String job_type;
	private int null_cnt;
	private String first_sql_name;

	public SearchVo() {
	}

	public SearchVo(int sabun, String name, String join_gbn_code, String put_yn, String pos_gbn_code, String join_day,
			String retire_day, String job_type, int null_cnt, String first_sql_name) {
		this.sabun = sabun;
		this.name = name;
		this.join_gbn_code = join_gbn_code;
		this.put_yn = put_yn;
		this.pos_gbn_code = pos_gbn_code;
		this.join_day = join_day;
		this.retire_day = retire_day;
		this.job_type = job_type;
		this.null_cnt = null_cnt;
		this.first_sql_name = first_sql_name;
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

	public String getJoin_gbn_code() {
		return join_gbn_code;
	}

	public void setJoin_gbn_code(String join_gbn_code) {
		this.join_gbn_code = join_gbn_code;
	}

	public String getPut_yn() {
		return put_yn;
	}

	public void setPut_yn(String put_yn) {
		this.put_yn = put_yn;
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

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public int getNull_cnt() {
		return null_cnt;
	}

	public void setNull_cnt(int null_cnt) {
		this.null_cnt = null_cnt;
	}

	public String getFirst_sql_name() {
		return first_sql_name;
	}

	public void setFirst_sql_name(String first_sql_name) {
		this.first_sql_name = first_sql_name;
	}

	@Override
	public String toString() {
		return "SearchVo [sabun=" + sabun + ", name=" + name + ", join_gbn_code=" + join_gbn_code + ", put_yn=" + put_yn
				+ ", pos_gbn_code=" + pos_gbn_code + ", join_day=" + join_day + ", retire_day=" + retire_day
				+ ", job_type=" + job_type + ", null_cnt=" + null_cnt + ", first_sql_name=" + first_sql_name + "]";
	}

}
