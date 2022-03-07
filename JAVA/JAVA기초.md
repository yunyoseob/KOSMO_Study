# JAVA 기초

### Q1. 자바로 개발할 때 필요한 4가지 도구

1. JDK
2. 에디터
3. 콘솔창(MS-DOS)
4. API

### Q2. javac와 java의 차이?

javac는 컴파일러로 사람이 인지하는 코드로 작성해서 컴퓨터가 알아볼 수 있게 하는 것
(Convert 소스코드 to 바이트코드) + 자바 소스를 자바의 규칙에 잘 맞게 작성했는지 검사
(규칙을 잘 지켰으면 JVM이 바이트 코드를 만든다.)

java는 jvm이 바이트코드를 cpu하고 통신해서 결과를 만드는 것

### Q3. API 구성원은?

rt.jar, src.jar에 jdk 1.8 자바소스(클래스)가 8천 여개가 있다.
클래스는 자바 프로그램의 최소 단위이다.

각각 파일을 뜯어서 볼 수 없기 때문에 개발자들이 API를 참고해서 편하게 
개발하라고 API를 제공한다.

### Q4. 키워드의 종류

[Java Language Keywords](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

![image](https://user-images.githubusercontent.com/81727895/153813200-9faa8c7c-6762-45bd-b822-1182f63e4b38.png)

|Java|Language|의|Keywods|입니다.|
|-|-|-|-|-|
|abstract|continue|for|new|switch|
|assert|default|goto|package|synchronized|
|boolean|do|if|private|this|
|break|double|implements|protected|throw|
|case|enum|instanceof|return|transient|
|catch|extends|int|short|try|
|char|final|interface|static|void|
|class|finally|long|strictfp|volatile|
|const|float|native|super|while|

### Q5. 연산자의 종류

```
+ - * /
< > = && || !=
```

== : 숫자 비교하는 연산자(상등 연산자)

### Q6. 식별자의 규칙

클래스이름: 영문자 대문자로 시작
함수이름: 영문자 소문자로 시작
변수이름: 영문자 소문자로 시작

### Q7. 빌트인 클래스의 종류

```
java.lang.String
  public char charAt(int index)
java.lang.System
  public static PrintStream out
java.util.Scanner
  public int nextInt()
java.io.PrintStream
java.lang.Byte
java.lang.Character
java.lang.Short
java.lang.Integer
java.lang.Long
java.lang.Float
java.lang.Double
```

### 변수의 종류(JAVA 데이터 타입)

**기초 자료형: 자바에서 사용하는 도구 중 유일하게 객체가 아니다. 래퍼 클래스(Wrapper Class)의 상수로 존재한다.**

```
int i=값
int iV=참조변수.함수();  static 이 없고 리턴형이 있는 함수
int iV1=클래스이름.함수(); static이 있고 리턴형이 있는 함수
int iV2=클래스이름.변수이름;
```

숫자
  정수
    byte
    short
    int
    long
  실수
    float
    double
문자
  char
논리
  boolean
  
**참조자료형 : 기초 자료형을 제외한 모든 것이다.**

```
데이터형 참조변수 = 주소값;
```
어떤 자원은 주소값을 생략하고 값 또는 다른 것을 리턴해 준다.

```
String s="abc";
Data d=new Date();
int i[]=new int[3]
```

## 객체지향 프로그래밍(Object Oriented Programming)

1. All Object
2. java.lang.Object 클래스가 루트 이면서
3. 클래스를 사용하려면 (클래스를 인스턴스, 클래스를 상속하려면, 클래스를 메모리에 올리려면)
  제일 먼저 생성자를 찾는다.
  생성자는 클래스를 사용하려고 할 때 제일 먼저 멤버 필드를 초기화 한다.



