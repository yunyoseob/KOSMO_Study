package a.b.c.com.kosmo.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_P 	= "P"; // 상품
	public static final String BIZ_GUBUN_C 	= "C"; // 카트
	public static final String BIZ_GUBUN_M 	= "M"; // 회원
	public static final String BIZ_GUBUN_B 	= "B"; // 게시판
	
	
	// type : D : 20210001, M : YYYYMM, Y : YYYY, N : 
	public static String numPad(String t, String c){
	
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	 
	public static String getProductChabun(String type, String memNum) {		
		return BIZ_GUBUN_P.concat(ChabunUtil.numPad(type, memNum));
	}
	
	public static String getCartChabun(String type, String memNum) {		
		return BIZ_GUBUN_C.concat(ChabunUtil.numPad(type, memNum));
	}
	
	public static String getMemberChabun(String type, String memNum) {		
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
	}
	
	public static String getBoardChabun(String type, String memNum) {		
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.getProductChabun("m", c));
		
	}
}
