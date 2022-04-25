
## 게시판 만들기 : Model 2 + Web MVC 패턴

======================================

모델 2 : jsp + servlet

M : Model		--> java

V : View		--> jsp

C : Controller	--> servlet

요구사항 : 일반 게시판 만들어주세요

	1. 회원제 게시판	: 회원 아이디  O
	2. 일반 게시판	: 회원 아이디  X
	
```sql
글 번호			B0000 : B 접두어 + XXXX 숫자 4개
글 제목			길이 100
글쓴이			길이 50
글 쓸때 사용한 패스워드	길이 300 8자리 이상 : 단방향 암호화
글 내용			길이 2000자

삭제여부			삭제여부 : Y : N
등록일			YYYY-MM-DD
수정일			YYYY-MM-DD
```

1. 데이터베이스 설계

```
	데이터베이스(Oracle 11g Release), JDBC 드라이버(ojdbc6.jar)
	
	데이터 소스
		JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclKM00";
		JDBC_USER = "scott";
		JDBC_PASSWORD = "tiger";
```

오라클 SID : Service Name 확인하기 

---------------------------------

```sql
	DB_UNIQUE_NAME 이름 사용하기 
	
	콘솔에서 
	sqlplus / as sysdba 또는 sqlplus "/as sysdba"
	
	SQL> SELECT NAME, DB_UNIQUE_NAME FROM V$DATABASE;
	
	NAME               DB_UNIQUE_NAME
	------------------ ------------------------------------------------------------
	ORCLHBE0           orclkm00
	
	SQL> SELECT INSTANCE FROM V$THREAD;
	
	INSTANCE

	orclkm00

	테이블 이름 : MVC_BOARD
	컬럼 : BNUM			VARCHAR2(20)
		 BSUBJECT		VARCHAR2(100)
		 BWRITER		VARCHAR2(30)
		 BPW			VARCHAR2(300)
		 BMEMO			VARCHAR2(2000)
		 DELETEYN		VARCHAR2(1)
		 INSERTDATE		DATE
		 UPDATEDATE		DATE

	CREATE TABLE MVC_BOARD(
		
		  BNUM				VARCHAR2(20)		PRIMARY KEY
		 ,BSUBJECT			VARCHAR2(100)		NOT NULL
		 ,BWRITER			VARCHAR2(30)
		 ,BPW				VARCHAR2(300)
		 ,BMEMO				VARCHAR2(2000)
		 ,DELETEYN			VARCHAR2(1)			NOT NULL
		 ,INSERTDATE		DATE
		 ,UPDATEDATE		DATE
	);
```

	인덱스확인
	
	채번확인

2. 프로그램 설계
	
```  
	Context : kosServlet
	package : a.b.c.com.kosmo.board
```

사용할 라이브러리 포팅하기 

---------------------------------------

```
	Context/WebContent/WEB-INF/lib/
	디비연결하는 jdbc 드라이버
	로그찍기 
```
	
	
	
**공통 클래스**

----------------------------

```java
	a.b.c.com.common
```	
	
**Controller**

----------------------------

```
	a.b.c.com.kosmo.board.controller
	BoardController
```

**Service**

----------------------------

```
	a.b.c.com.kosmo.board.service
	BoardService
		public ArrayList<BoardVO> boardSelectAll();
		public ArrayList<BoardVO> boardSelect(BoardVO bvo);
		public boolean boardInsert(BoardVO bvo);
		public boolean boardUpdate(BoardVO bvo);
		public boolean boardDelete(BoardVO bvo);
	BoardServiceImpl
```

**DAO**

----------------------------

```java
	a.b.c.com.kosmo.board.dao
	BoardDAO
		public ArrayList<BoardVO> boardSelectAll();
		public ArrayList<BoardVO> boardSelect(BoardVO bvo);
		public boolean boardInsert(BoardVO bvo);
		public boolean boardUpdate(BoardVO bvo);
		public boolean boardDelete(BoardVO bvo);
	BoardDAOImpl
```	
**SQL**

----------------------------

```java
	a.b.c.com.kosmo.board.sql
	BoardSqlMap
		public static String getBoardSelectAll(){ return null;}
		public static String getBoardSelect(){ return null;}
		public static String getBoardInsert(){ return null;}
		public static String getBoardUpdate(){ return null;}
		public static String getBoardDelete(){ return null;}
```	

**VO**

----------------------------
```java
	a.b.c.com.kosmo.board.vo
	BoardVO
		private String bnum;
		private String bsubject;
		private String bwriter;
		private String bpw;
		private String bmemo;		
		private String deleteyn;
		private String insertdate;
		private String updatedate;
```	
	
**view : jsp**

----------------------------

```java
	/kosServlet/WebContent/kosmo/board
		board.html
		boardSelectAll.jsp
		boardSelect.jsp
		boardInsert.jsp
		boardUpdate.jsp
		boardDelete.jsp
```    
