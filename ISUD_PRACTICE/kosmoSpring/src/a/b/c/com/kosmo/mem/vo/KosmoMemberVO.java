package a.b.c.com.kosmo.mem.vo;

public class KosmoMemberVO {
	
	private String kmnum;
	private String kmid;
	private String kmpw;
	private String kmname;
	private String kmhp;
	private String kmemail;
	private String kmzone;
	private String kmroad;
	private String kmroad2;
	private String kmjibun;
	private String kmimage;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public KosmoMemberVO() {
		
	}
	
	public KosmoMemberVO(String kmnum, String kmid, String kmpw, String kmname, String kmhp, String kmemail,
			String kmzone, String kmroad, String kmroad2, String kmjibun, String kmimage, String deleteyn,
			String insertdate, String updatedate) {
		
		this.kmnum = kmnum;
		this.kmid = kmid;
		this.kmpw = kmpw;
		this.kmname = kmname;
		this.kmhp = kmhp;
		this.kmemail = kmemail;
		this.kmzone = kmzone;
		this.kmroad = kmroad;
		this.kmroad2 = kmroad2;
		this.kmjibun = kmjibun;
		this.kmimage = kmimage;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}



	// setter/getter
	public String getKmnum() {
		return kmnum;
	}

	public String getKmid() {
		return kmid;
	}

	public String getKmpw() {
		return kmpw;
	}

	public String getKmname() {
		return kmname;
	}

	public String getKmhp() {
		return kmhp;
	}

	public String getKmemail() {
		return kmemail;
	}

	public String getKmzone() {
		return kmzone;
	}

	public String getKmroad() {
		return kmroad;
	}

	public String getKmroad2() {
		return kmroad2;
	}

	public String getKmjibun() {
		return kmjibun;
	}

	public String getKmimage() {
		return kmimage;
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

	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
	}

	public void setKmid(String kmid) {
		this.kmid = kmid;
	}

	public void setKmpw(String kmpw) {
		this.kmpw = kmpw;
	}

	public void setKmname(String kmname) {
		this.kmname = kmname;
	}

	public void setKmhp(String kmhp) {
		this.kmhp = kmhp;
	}

	public void setKmemail(String kmemail) {
		this.kmemail = kmemail;
	}

	public void setKmzone(String kmzone) {
		this.kmzone = kmzone;
	}

	public void setKmroad(String kmroad) {
		this.kmroad = kmroad;
	}

	public void setKmroad2(String kmroad2) {
		this.kmroad2 = kmroad2;
	}

	public void setKmjibun(String kmjibun) {
		this.kmjibun = kmjibun;
	}

	public void setKmimage(String kmimage) {
		this.kmimage = kmimage;
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
