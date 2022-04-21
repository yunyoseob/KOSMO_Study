package a.b.c.test.mail;

public class TpwVO {
	
	private String tnum;
	private String thp;
	private String temail;
	private String tpw;
	private String insertdate;
	
	// 생성자
	public TpwVO() {
		
	}
	
	public TpwVO(String tnum, String thp, String temail, String tpw, String insertdate) {
		super();
		this.tnum = tnum;
		this.thp = thp;
		this.temail = temail;
		this.tpw = tpw;
		this.insertdate = insertdate;
	}
	
	
	// getter
	public String getTnum() {
		return tnum;
	}
	public String getThp() {
		return thp;
	}
	public String getTemail() {
		return temail;
	}
	public String getTpw() {
		return tpw;
	}
	public String getInsertdate() {
		return insertdate;
	}
	
	// setter
	public void setTnum(String tnum) {
		this.tnum = tnum;
	}
	public void setThp(String thp) {
		this.thp = thp;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public void setTpw(String tpw) {
		this.tpw = tpw;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
}
