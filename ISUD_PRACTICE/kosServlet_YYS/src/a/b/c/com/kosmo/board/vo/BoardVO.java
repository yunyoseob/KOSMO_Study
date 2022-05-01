package a.b.c.com.kosmo.board.vo;

public class BoardVO {
	private String bnum;
	private String bsubject;
	private String bwriter;
	private String bpw;
	private String bmemo;		
	private String deleteyn;
	private String insertdate;
	private String updatedate;

	public BoardVO(){
		
	}
	
	public BoardVO(String bnum, String bsubject, String bwriter, 
			       String bpw, String bmemo, String deleteyn,
			       String insertdate, String updatedate) {
		super();
		this.bnum = bnum;
		this.bsubject = bsubject;
		this.bwriter = bwriter;
		this.bpw = bpw;
		this.bmemo = bmemo;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	public String getBnum() {
		return bnum;
	}

	public String getBsubject() {
		return bsubject;
	}

	public String getBwriter() {
		return bwriter;
	}

	public String getBpw() {
		return bpw;
	}

	public String getBmemo() {
		return bmemo;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	public void setBmemo(String bmemo) {
		this.bmemo = bmemo;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
