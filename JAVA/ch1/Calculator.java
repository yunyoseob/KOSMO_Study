package a.b.c.ch1;

public class Calculator{
	public static int addN(int x, int y){
		// x, y가 int임을 선언
		int add=x+y;
		// add가 int임을 선언
		return add;
	}
	
	public static int timesN(int x, int y){
		int times=x*y;
		return times;
	}
	public static int minusN(int x,int y){
		int minus=x-y;
		return minus;
	}
	public static float devideN(float x,float y){
		float devide=x/y;
		return devide;
	}

	public static void main(String args[]){
		int a=10;
		int b=2;

		System.out.println("add : "+Calculator.addN(a,b)+"\n");
		System.out.println("times : "+Calculator.timesN(a,b)+'\n');
		System.out.println("minus : "+Calculator.minusN(a,b)+'\n');
		System.out.println("devide : "+Calculator.devideN(a,b)+'\n');
	}
} // end of Calculator