package a.b.c.com.kosmo.like.vo;

public class KosmoBoardLikeVO {
	
	private String kblnum;
	private String kmnum;
	private String kbnum;
	private String kblike_cnt_1;
	private String kblike_cnt_2;
	private String kblike_cnt_3;
	private String kblike_cnt_4;
	private String kblike_cnt_5;
	private String kblike_cnt_6;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public KosmoBoardLikeVO() {
	
	}
	
	public KosmoBoardLikeVO(String kblnum, String kmnum, String kbnum, String kblike_cnt_1, String kblike_cnt_2,
			String kblike_cnt_3, String kblike_cnt_4, String kblike_cnt_5, String kblike_cnt_6, String deleteyn,
			String insertdate, String updatedate) {
		
		this.kblnum = kblnum;
		this.kmnum = kmnum;
		this.kbnum = kbnum;
		this.kblike_cnt_1 = kblike_cnt_1;
		this.kblike_cnt_2 = kblike_cnt_2;
		this.kblike_cnt_3 = kblike_cnt_3;
		this.kblike_cnt_4 = kblike_cnt_4;
		this.kblike_cnt_5 = kblike_cnt_5;
		this.kblike_cnt_6 = kblike_cnt_6;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	// setter/getter
	public String getKblnum() {
		return kblnum;
	}
	public void setKblnum(String kblnum) {
		this.kblnum = kblnum;
	}
	public String getKmnum() {
		return kmnum;
	}
	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
	}
	public String getKbnum() {
		return kbnum;
	}
	public void setKbnum(String kbnum) {
		this.kbnum = kbnum;
	}
	public String getKblike_cnt_1() {
		return kblike_cnt_1;
	}
	public void setKblike_cnt_1(String kblike_cnt_1) {
		this.kblike_cnt_1 = kblike_cnt_1;
	}
	public String getKblike_cnt_2() {
		return kblike_cnt_2;
	}
	public void setKblike_cnt_2(String kblike_cnt_2) {
		this.kblike_cnt_2 = kblike_cnt_2;
	}
	public String getKblike_cnt_3() {
		return kblike_cnt_3;
	}
	public void setKblike_cnt_3(String kblike_cnt_3) {
		this.kblike_cnt_3 = kblike_cnt_3;
	}
	public String getKblike_cnt_4() {
		return kblike_cnt_4;
	}
	public void setKblike_cnt_4(String kblike_cnt_4) {
		this.kblike_cnt_4 = kblike_cnt_4;
	}
	public String getKblike_cnt_5() {
		return kblike_cnt_5;
	}
	public void setKblike_cnt_5(String kblike_cnt_5) {
		this.kblike_cnt_5 = kblike_cnt_5;
	}
	public String getKblike_cnt_6() {
		return kblike_cnt_6;
	}
	public void setKblike_cnt_6(String kblike_cnt_6) {
		this.kblike_cnt_6 = kblike_cnt_6;
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
