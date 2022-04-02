package a.b.c.common;

public abstract class CodeUtil {
	
		
	// 성별 라벨
	public static final String[] gender_value = {"여자","남자"};
	
	// 핸드폰 라벨
	public static final String[] hp_value = {"010", "011", "016", "017"};
	
	
	// 취미 라벨
	public static final String[] hobby_lavel = {"독서", "운동", "음악감상", "여행"};
	public static final String[] hobby_value = {"01", "02", "03", "04"};
		
	// 성별
	public static String gender(String s) {
		return "01".equals(s.toUpperCase()) ? "여자" : "남자";
	}
	
	
	// 핸드폰 
	public static String hp(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (11 == sLen) {
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}		
		return ss;
	}

	// 취미들 
	public static String hobbys(String s){
		System.out.println(s);
		String h = "";
		String ss[] = s.split(",");
		for (int i=0; i < ss.length; i++){			
			System.out.println(hobby(ss[i]));
			h += hobby(ss[i]) + " ";
		}		
		return h;
	}
	
	// 취미
	public static String hobby(String s) {
		
		String h = "";				
		if (s !=null && s.length() > 0){							
			for (int i=1; i < hobby_lavel.length; i++) {	
				if (("0" + i).equals(s)) {
					h = CodeUtil.hobby_lavel[i-1];
				}
			}			
		}		
		return h;
	}
		
	
	public static void main(String args[]) {
				
		// 핸드폰
		String hp = CodeUtil.hp("01012341234");		
		System.out.println("hp >>> : " + hp);		
		
		// 성별
		String g = CodeUtil.gender("F");
		System.out.println("g >>> : " + g);
		// 취미
		String h = CodeUtil.hobby("02");
		System.out.println("h >>> : " + h);
		// 취미들
		String hs = CodeUtil.hobbys("01,02,03,");
		System.out.println("hs >>> : " + hs);		
	}
}
