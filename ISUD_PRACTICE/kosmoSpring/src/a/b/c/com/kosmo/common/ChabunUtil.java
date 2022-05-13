package a.b.c.com.kosmo.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_P 	= "P"; // 
	
	
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
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.getProductChabun("m", c));
		
	}
}
