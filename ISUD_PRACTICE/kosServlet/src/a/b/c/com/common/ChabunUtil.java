package a.b.c.com.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_BOARD = "B"; 
			
	public static String numPad(String t, String c){

		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		String ymd = DateFormatUtil.ymdFormats(t);
		return ymd.concat(c);
	}
	
	public static String getBoardChabun(String type) {
		
		String commNum = ChabunQuery.getBoardChabunQuery();	
		return BIZ_GUBUN_BOARD.concat(ChabunUtil.numPad(type, commNum));									
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		System.out.println(">>> : " + ChabunUtil.getBoardChabun(""));
	}
}
