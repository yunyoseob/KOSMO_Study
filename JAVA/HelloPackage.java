package a.b.c;

// a.b.c.HelloPackage
public class HelloPackage {

	public static void main(String args[]){
	
		System.out.println("java pacakge test");
	}
}

/*
C:\00.KOSMO108\10.JExam>javac -d . HelloPackage.java

	javac : �����Ϸ� 
	-d :  -d <directory> Specify where to place generated class files
	. : ���� ���丮 
	C:\00.KOSMO108\10.JExam>javac -d . : C:\00.KOSMO108\10.JExam> ��⼭ ��Ű���� ���弼��
	HelloPackage.java : �ҽ� ���� 

C:\00.KOSMO108\10.JExam>java a.b.c.HelloPackage
	C:\00.KOSMO108\10.JExam\a\b\c>HelloPackage.class

	java : ���� ��ɾ�� �������� ��ġ(���丮)���� �Ѵ�. 
	a.b.c.HelloPackage : ��Ű���̸�(a.b.c) + Ŭ�����̸�(HelloPackage) 

java pacakge test

C:\00.KOSMO108\10.JExam>java a/b/c/HelloPackage
java pacakge test


C:\00.KOSMO108\10.JExam>javap a.b.c.HelloPackage
Compiled from "HelloPackage.java"
public class a.b.c.HelloPackage {
  public a.b.c.HelloPackage();
  public static void main(java.lang.String[]);
}
*/