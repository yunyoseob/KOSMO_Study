package a.b.c.com.kosmo.rboard.vo;

public class KosmoRboardVO {

	private String rkbnum;
	private String kbnum;
	private String rkbname;
	private String rkbcontent;		
	private String insertdate;
	
	// 생성자 
	public KosmoRboardVO() {
		
	}

	public KosmoRboardVO(String rkbnum, String kbnum, String rkbname, String rkbcontent, String insertdate) {
		
		this.rkbnum = rkbnum;
		this.kbnum = kbnum;
		this.rkbname = rkbname;
		this.rkbcontent = rkbcontent;
		this.insertdate = insertdate;
	}
	
	// setter/getter
	public String getRkbnum() {
		return rkbnum;
	}
	public void setRkbnum(String rkbnum) {
		this.rkbnum = rkbnum;
	}
	public String getKbnum() {
		return kbnum;
	}
	public void setKbnum(String kbnum) {
		this.kbnum = kbnum;
	}
	public String getRkbname() {
		return rkbname;
	}
	public void setRkbname(String rkbname) {
		this.rkbname = rkbname;
	}
	public String getRkbcontent() {
		return rkbcontent;
	}
	public void setRkbcontent(String rkbcontent) {
		this.rkbcontent = rkbcontent;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
}
