package com.insa.vo;

public class InputInfoVo {
	private int sabun;
	private int seq;
	private String wrk_posb_day;
	private int sugst_money;
	private String pjt_gbn_code;
	private String eqm_yn;
	private int current_salary;
	private String work_area;

	public InputInfoVo() {
	}

	public InputInfoVo(int sabun, int seq, String wrk_posb_day, int sugst_money, String pjt_gbn_code, String eqm_yn,
			int current_salary, String work_area) {
		this.sabun = sabun;
		this.seq = seq;
		this.wrk_posb_day = wrk_posb_day;
		this.sugst_money = sugst_money;
		this.pjt_gbn_code = pjt_gbn_code;
		this.eqm_yn = eqm_yn;
		this.current_salary = current_salary;
		this.work_area = work_area;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWrk_posb_day() {
		return wrk_posb_day;
	}

	public void setWrk_posb_day(String wrk_posb_day) {
		this.wrk_posb_day = wrk_posb_day;
	}

	public int getSugst_money() {
		return sugst_money;
	}

	public void setSugst_money(int sugst_money) {
		this.sugst_money = sugst_money;
	}

	public String getPjt_gbn_code() {
		return pjt_gbn_code;
	}

	public void setPjt_gbn_code(String pjt_gbn_code) {
		this.pjt_gbn_code = pjt_gbn_code;
	}

	public String getEqm_yn() {
		return eqm_yn;
	}

	public void setEqm_yn(String eqm_yn) {
		this.eqm_yn = eqm_yn;
	}

	public int getCurrent_salary() {
		return current_salary;
	}

	public void setCurrent_salary(int current_salary) {
		this.current_salary = current_salary;
	}

	public String getWork_area() {
		return work_area;
	}

	public void setWork_area(String work_area) {
		this.work_area = work_area;
	}

	@Override
	public String toString() {
		return "InputInfoVo [sabun=" + sabun + ", seq=" + seq + ", wrk_posb_day=" + wrk_posb_day + ", sugst_money="
				+ sugst_money + ", pjt_gbn_code=" + pjt_gbn_code + ", eqm_yn=" + eqm_yn + ", current_salary="
				+ current_salary + ", work_area=" + work_area + "]";
	}

}
