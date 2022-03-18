# 요구사항

추가 요구 사항 2022-03-17
프로젝트를 신규로 만들어서 한다.
프로젝트 이름 
이니셜Project
단 이니셜은 소문자로 한다.
예) 박건원 : pgwProject 

TEST_T6 테이블 ISUD , CRUD 하기 

- 데이터

```sql
회원번호		T1 NOT NULL VARCHAR2(20) PRIMARY KEY 회원번호 규칙 :  T6 + YYYYMMDD + 0001 : T6202203160001
회원이름		T2 NOT NULL VARCHAR2(20) 
회원나이		T3          NUMBER(3)  
회원여부		T4 NOT NULL VARCHAR2(1)  Y : N
입력일		T5          DATE  최초 입력일				YYYY-MM-DD
수정일		T6          DATE  변경 : UPDATE, DELETE  YYYY-MM-DD 
```

변수는 데이터베이스 컬럼명을 소문자로 만든다.

```java
private String t1;
private String t2;
private String t3;
private String t4;
private String t5;
private String t6;
```


1. 테이블 정의서 만들기 
	엑셀

2. 테이블 만들기

```sql
	SID : orcl이니셜00
	account : scott/tiger

CREATE TABLE TEST_T6 (
	 T1 VARCHAR2(20) PRIMARY KEY
	,T2 VARCHAR2(20) 
	,T3 NUMBER(3)  
	,T4 VARCHAR2(1)  
	,T5 DATE
	,T6 DATE
);
```

3. 클래스 설계서 만들기 

```java
패키지 
a.b.c.t6.scr
a.b.c.t6.servie
a.b.c.t6.dao
a.b.c.t6.sql
a.b.c.t6.vo
a.b.c.common

클래스 
화면 : 콘솔
	T6Scr.java
		public ArrayList<T6VO> t6SelectAll();
		public ArrayList<T6VO> t6SelectName();
		public ArrayList<T6VO> t6SelectDate();

		public boolean t6Insert();
		public boolean t6Update();
		public boolean t6Delete();
서비스 
	T6Service.java 인터페이스 
		public ArrayList<T6VO> t6SelectAll();
		public ArrayList<T6VO> t6SelectName(T6VO tvo);
		public ArrayList<T6VO> t6SelectDate(T6VO tvo);

		public boolean t6Insert(T6VO tvo);
		public boolean t6Update(T6VO tvo);
		public boolean t6Delete(T6VO tvo);
	T6ServiceImpl.java 클래스 
다오 
	T6DAO.java 인터페이스 
		public ArrayList<T6VO> t6SelectAll();
		public ArrayList<T6VO> t6SelectName(T6VO tvo);
		public ArrayList<T6VO> t6SelectDate(T6VO tvo);

		public boolean t6Insert(T6VO tvo);
		public boolean t6Update(T6VO tvo);
		public boolean t6Delete(T6VO tvo);
	T6DAOImpl.java 클래스 
sql
	T6QueryMap.java
		public String getT6SelectAll();
		public String getT6SelectName();
		public String getT6SelectDate();

		public String getT6Insert();
		public String getT6Update();
		public String getT6Delete();
vo
	T6VO.java
		private String t1;
		private String t2;
		private String t3;
		private String t4;
		private String t5;
		private String t6;
common
	OracleConnProperty.java
	ChabunQuery.java 
		public static final short CHABUN_QUERY_T6 = 1;
		public static String chabun_query[] = {};		
		public static String getT6ChabunQuery();

	ChabunUtil.java
		public static String getT6Chabun(String type);
	
	DateFormatUtil.java
	DateUtil.java
```




