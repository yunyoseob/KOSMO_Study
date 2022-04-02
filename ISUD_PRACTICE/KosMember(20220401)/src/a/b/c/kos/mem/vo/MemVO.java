package a.b.c.kos.mem.vo;

public class MemVO {
	
	private String mnum;
	private String mname;
	private String mid;
	private String mpw;
	private String mhp;
	private String memail;
	private String mgender;
	private String mhobby;	
	private String mzone;
	private String mroad;
	private String mroaddetail;
	private String mjibun;	
	private String mlocal;
	private String mmsg;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	private String searchFilter;	// 검색조건
	private String keyword;			// 검색어
	private String fromdate;		// 검색기간 시작일
	private String todate;			// 검색기간 종료일

	
	// 생성자
	public MemVO() {
		
	}
	
	public MemVO(	String mnum, String mname, String mid, String mpw, String mhp, String memail, String mgender,
					String mhobby, String mzone, String mroad, String mroaddetail, String mjibun, String mlocal, String mmsg,
					String deleteyn, String insertdate, String updatedate) {		
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.mhp = mhp;
		this.memail = memail;
		this.mgender = mgender;
		this.mhobby = mhobby;
		this.mzone = mzone;
		this.mroad = mroad;
		this.mroaddetail = mroaddetail;
		this.mjibun = mjibun;
		this.mlocal = mlocal;
		this.mmsg = mmsg;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	// getter()
	public String getMnum() {
		return mnum;
	}
	public String getMname() {
		return mname;
	}
	public String getMid() {
		return mid;
	}
	public String getMpw() {
		return mpw;
	}
	public String getMhp() {
		return mhp;
	}
	public String getMemail() {
		return memail;
	}
	public String getMgender() {
		return mgender;
	}
	public String getMhobby() {
		return mhobby;
	}
	public String getMzone() {
		return mzone;
	}
	public String getMroad() {
		return mroad;
	}
	public String getMroaddetail() {
		return mroaddetail;
	}
	public String getMjibun() {
		return mjibun;
	}
	public String getMlocal() {
		return mlocal;
	}
	public String getMmsg() {
		return mmsg;
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
	
	
	// setter()
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public void setMhp(String mhp) {
		this.mhp = mhp;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public void setMhobby(String mhobby) {
		this.mhobby = mhobby;
	}
	public void setMzone(String mzone) {
		this.mzone = mzone;
	}
	public void setMroad(String mroad) {
		this.mroad = mroad;
	}
	public void setMroaddetail(String mroaddetail) {
		this.mroaddetail = mroaddetail;
	}
	public void setMjibun(String mjibun) {
		this.mjibun = mjibun;
	}
	public void setMlocal(String mlocal) {
		this.mlocal = mlocal;
	}
	public void setMmsg(String mmsg) {
		this.mmsg = mmsg;
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

	// 검색 관련 getter() / setter()
	public String getSearchFilter() {
		return searchFilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getFromdate() {
		return fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	 
	
	
}
