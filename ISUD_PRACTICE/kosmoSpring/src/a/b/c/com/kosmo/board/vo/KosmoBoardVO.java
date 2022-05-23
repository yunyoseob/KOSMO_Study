package a.b.c.com.kosmo.board.vo;

public class KosmoBoardVO {
    
    private String kbnum;
	private String kbsubject;
	private String kbname;
	private String kbcontent;
	private String kbfile;
	private String kbpw;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public KosmoBoardVO() {
		
	}
	
	public KosmoBoardVO(String kbnum, String kbsubject, String kbname, String kbcontent, String kbfile, String kbpw,
			String deleteyn, String insertdate, String updatedate) {

		this.kbnum = kbnum;
		this.kbsubject = kbsubject;
		this.kbname = kbname;
		this.kbcontent = kbcontent;
		this.kbfile = kbfile;
		this.kbpw = kbpw;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	
	// setter/getter
	public String getKbnum() {
		return kbnum;
	}
	public void setKbnum(String kbnum) {
		this.kbnum = kbnum;
	}
	public String getKbsubject() {
		return kbsubject;
	}
	public void setKbsubject(String kbsubject) {
		this.kbsubject = kbsubject;
	}
	public String getKbname() {
		return kbname;
	}
	public void setKbname(String kbname) {
		this.kbname = kbname;
	}
	public String getKbcontent() {
		return kbcontent;
	}
	public void setKbcontent(String kbcontent) {
		this.kbcontent = kbcontent;
	}
	public String getKbfile() {
		return kbfile;
	}
	public void setKbfile(String kbfile) {
		this.kbfile = kbfile;
	}
	public String getKbpw() {
		return kbpw;
	}
	public void setKbpw(String kbpw) {
		this.kbpw = kbpw;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
}
