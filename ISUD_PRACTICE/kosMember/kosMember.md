미니프로젝트 작성 기간 : 2022-03-30 17시 ~ 2022-04-01 12시 35분

> **작성 기준**

```java

======================================================
						JAVA
======================================================


서비스 
a.b.c.kos.mem.service
	interface MemService_PGW 인터페이스
		//함수---------------------------------------------------
		public ArrayList<MemVO> memSelectAll();
		public ArrayList<MemVO> memSelectMnum(MemVO mvo);
		public ArrayList<MemVO> memSelectMname(MemVO mvo);
		public ArrayList<MemVO> memSelectMinsertdate(MemVO mvo);
		public boolean memInsert(MemVO mvo);
		public boolean memUpdate(MemVO mvo);
		public boolean memDelete(MemVO mvo);
		//이하 함수 생략, 선정 이하 클래스에서 일괄 수정
		---------------------------------------------------
	class MemServiceImpl_PGW
		1. DAO 부모선언-자식 인스턴스(new)를 위한  참조변수 
			MemDAO_PGW [후보 :'mdao'] = new MemDAOImpl_PGW();
		2. ISUD 중 S(이름,날짜,번호검색)의 [후보 return 'aList']
		
다오 
a.b.c.kos.mem.dao
	interface MemDAO_PGW
		
		
	class MemDAOImpl_PGW
		1. 공통 변수 
			- Insert,Update,Delete 에서 SQL 질의문을 담을 MemVO_PGW 클래스변수
				[후보 : '_mvo']
			- 쿼리문을 연결할 String 변수(PreparedStatement(변수))
				[후보 : 'sql']
			- IUD의 리턴형 [후보 : return 'bool']

			
		
sql
a.b.c.kos.mem.sql
	class MemQueryMap_PGW
		1. StringBuffer 참조변수 [후보 : 'sb']
		

vo 
a.b.c.kos.mem.vo
	class MemVO_PGW
		1. 공통변수
			- 날짜 검색에 필요한 [후보 : 'fromdate'] / [후보 : 'todate']
공통 클래스 
a.b.c.common
		OracleConnProperty_PGW
			1. 연결상수 
				[후보 : 'JDBC_DRVER' / 'JDBC_URL' / 'JDBC_USER' / 'JDBC_PASSWORD']
			2. 연결/쿼리문 변수 
				[후보 : Connection 'conn']
				[후보 : PreparedStatement 'pstmt']
				[후보 : ResultSet 'rsRs']
			3. 통신종료함수 
				[후보 : 'conClose'(conn, pstmt, rsRs);]
				[후보 : 'conClose'(conn, pstmt);]
		ChabunQuery_PGW
			1. SQL의 "MNUM"칼럼의 최고 숫자를 알기 위한 쿼리문을 가지는 배열의 index를 지칭하는 상수 
				[후보 : 'CHABUN_QUERY_KOSMO' = 0;]
				//cf) 만약 배열로 안 하고 직접 상수=쿼리문 이라고 했을 경우 무시
			2. -4번째 index숫자를 긁어오는 함수 
				[후보 : 'getKOSChabunQuery()'] //cf)본래 getT6ChabunQuery()
			3. -4번째 인덱스
				[후보 : 'mNum']//cf)본래 commNum
		DateFormatUtil_PGW
			1. 굳이 바꿀 필요가 있나?
		DateUtil_PGW
			1. 굳이 바꿀 필요가 있나?
		ChabunUtil_PGW
			1. 채번접두어문자"M"을 가르키는 상수명
				[후보 : 'BIZ_GUBUN_KOSMO']
			2. 최종적으로 채번로직의 결과값을 생성하는 함수 
				[후보 : getKOSChabun(String type)]//cf) 본래 getT6ChabunQuery()


======================================================
					  HTML/JSP
======================================================

1. mem.html 고정
	- 회원번호검색(mnum)
		=<form name="memSelectMnum" id="memSelectMnum"> 
		=<input type="button" id="mnum_btn" value="회원번호검색" />
	- 회원이름검색(mname)
		=<form name="memSelectMname" id="memSelectMname">
		=<input type="button" id="mname_btn" value="회원이름검색" />
	- 회원등록날짜검색(insertdate)
		=<form name="memSelectInsertdate" id="memSelectInsertdate">
		=<input type="text" name="fromdate" id="fromdate"> ~
		=<input type="text" name="todate"	 id="todate">
		=<input type="button" id="insertdate_btn" value="등록날짜검색">
	- 회원등록(insert)
		<form name="memInsert" id="memInsert">
		<input type="text" name="mname" id="mname"><br>
		<input type="text" name="mid" id="mid"><br>
		<input type="text" name="mpw" id="mpw"><br>
		<input type="text" name="mhp" id="mhp"><br>
		<input type="text" name="memail" id="memail"><br>
		<input type="text" name="mgender" id="mgender"><br>
		<input type="text" name="mhobby" id="mhobby"><br>
		<input type="text" name="mlocal" id="mlocal"><br>
		<input type="text" name="mmsg" id="mmsg"><br>
		<input type="button" id="insert_btn" value="회원가입" />
	- 회원정보수정(update)
		<form name="memInsert" id="memInsert">
		<input type="text" name="mnum" id="mnum">회원번호<br>
		<input type="button" id="update_btn" value="회원정보수정" />
	- 회원정보삭제(Delete)
		<form name="mdmDelete" id="mdmDelete">
		<input type="text" name="mnum" id="mnum">
		<input type="button" id="delete_btn" value="회원번호로확인" />
2. memSelectAll.jsp : 전체
	- Service를 인스턴스해올 이름 
		[후보 : MemService_PGW 'ms' = new MemServiceImpl_PGW();]
	- 쿼리 질의문이 담길 ArrayList
		[후보 : ArrayList<MemVO_PGW> 'aList' = ms.memSelectAll();]
	- for문으로 'aList'에 담긴 MemVO_PGW클래스를 빼내기 위해 선언하는 MemVO_PGW의 변수
		[후보 : MemVO_PGW 'mvo' = aList.get(i);
]

3. memSelect.jsp : 회원번호, 이름, 날짜
	- '_mvo'?

4. memInsert.jsp 고정
	- 'bool'?

5. memUpdate.jsp
	-각 컬럼마다 id와 name
	[후보 : 'Mnum']
	//cf) 강사님거 보고 따라치느라 이렇게 됨.
	//mem.html과의 통일감을 위해선 mnum이 맞긴 함
	<input type="button" value="수정" id="update">
	<input type="button" value="삭제" id="delete">

5.1 'memUpdateOK.jsp'
	//앞에서 다 정해짐
6. memDelete.jsp
	//앞에서 다 정해짐
6.1 'memDelete.jsp'
	//앞에서 다 정해짐


```
