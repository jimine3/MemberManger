package co.yedam.membermanger.dto;

import java.sql.Date;

public class MemberDto {
	private String mId;
	private String mPass;
	private String mName;
	private String mAddr;
	private Date mDate;
	private String mGrant;
	
	public MemberDto() {
		
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mid) {
		this.mId = mid;
	}

	public String getmPass() {
		return mPass;
	}

	public void setmPass(String mPass) {
		this.mPass = mPass;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public String getmGrant() {
		return mGrant;
	}

	public void setmGrant(String mGrant) {
		this.mGrant = mGrant;
	}

	
}
