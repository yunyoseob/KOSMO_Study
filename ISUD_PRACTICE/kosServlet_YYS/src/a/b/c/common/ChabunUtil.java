package a.b.c.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class ChabunUtil {
	static Logger logger = LogManager.getLogger(ChabunUtil.class);
	public static final String BIZ_GUBUN_MEMBER="M";
	public static final String BIZ_GUBUN_BOARD="B";
	
	
	public static String numPad(String t, String c){
		for(int i=c.length(); i<4; i++){
			c="0"+c;
		}
		String ymd=DateFormatUtil.ymdFormats(t);
		return c;
	}
	
	public static String numPad(String c){
		logger.info("numPad(String c) 함수 진입 >>> : ");
		for(int i=c.length(); i<4; i++){
			c="0"+c;
		}
		return c;
	}
							
	public static String getMemChabun(String type){
		String commNum=ChabunQuery.getBoardChabunQuery();
		return BIZ_GUBUN_MEMBER.concat(ChabunUtil.numPad(type, commNum));
	}
									
	public static String getBoardChabun(String commNum){
		logger.info("getBoardChabun(String commNum) 함수 진입 >>> : ");
		logger.info("commNum >>> : "+commNum);
		return BIZ_GUBUN_BOARD.concat(ChabunUtil.numPad(commNum));
	}
	
	public static void main(String[] args) {
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("d"));
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("m"));
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("y"));
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("n"));
	}
}
