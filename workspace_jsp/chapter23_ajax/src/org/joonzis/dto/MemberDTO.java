package org.joonzis.dto;

public class MemberDTO {
	private int mIdx;      
	private String mid, mPw, mName, mEmail, mPhone, mAddr;  
	
	public MemberDTO() {
	}

	public MemberDTO(int mIdx, String mid, String mPw, String mName, String mEmail, String mPhone, String mAddr) {
		super();
		this.mIdx = mIdx;
		this.mid = mid;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhone = mPhone;
		this.mAddr = mAddr;
	}

	public int getMidx() {
		return mIdx;
	}

	public void setMidx(int mIdx) {
		this.mIdx = mIdx;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}
	
	
}
