package a.b.c.ch1;

public class Add_One_To_Ten{
	public static int oneS(){
	// 식별자 함수 이름앞에 int 붙여준뒤, int 값을 넣고, int 값을 리턴해야한다.
		int a=1;
		return a;
	}

	public static int twoS(){
		int b=Add_One_To_Ten.oneS();
		int n_2=2;
		return b+n_2;
	}
	
	public static int threeS(){
		int c=Add_One_To_Ten.twoS();
		int n_3=3;
		return c+n_3;
	}

	public static int fourS(){
		int d=Add_One_To_Ten.threeS();
		int n_4=4;
		return d+n_4;
	}

	public static int fiveS(){
		int f=Add_One_To_Ten.fourS();
		int n_5=5;
		return f+n_5;
	}

	public static int sixS(){
		int g=Add_One_To_Ten.fiveS();
		int n_6=6;
		return g+n_6;
	}

	public static int sevenS(){
		int h=Add_One_To_Ten.sixS();
		int n_7=7;
		return h+n_7;
	}

	public static int eightS(){
		int i=Add_One_To_Ten.sevenS();
		int n_8=8;
		return i+n_8;
	}

	public static int nineS(){	
		int j=Add_One_To_Ten.eightS();
		int n_9=9;
		return j+n_9;
	}

	public static int tenS(){
		int k=Add_One_To_Ten.nineS();
		int n_10=10;
		return k+n_10;
	}

	public static void main(String args[]){
		int sum_2=Add_One_To_Ten.twoS();
		int sum_3=Add_One_To_Ten.threeS();
		int sum_4=Add_One_To_Ten.fourS();
		int sum_5=Add_One_To_Ten.fiveS();
		int sum_6=Add_One_To_Ten.sixS();
		int sum_7=Add_One_To_Ten.sevenS();
		int sum_8=Add_One_To_Ten.eightS();
		int sum_9=Add_One_To_Ten.nineS();
		int sum_10=Add_One_To_Ten.tenS();
		// 함수에서 return한 값을 int로 지정한 sum_n에 대입한다. 

		System.out.println("1부터 2까지 합 : "+sum_2+"\n");
		System.out.println("1부터 3까지 합 : "+sum_3+"\n");
		System.out.println("1부터 4까지 합 : "+sum_4+"\n");
		System.out.println("1부터 5까지 합 : "+sum_5+"\n");
		System.out.println("1부터 6까지 합 : "+sum_6+"\n");
		System.out.println("1부터 7까지 합 : "+sum_7+"\n");
		System.out.println("1부터 8까지 합 : "+sum_8+"\n");
		System.out.println("1부터 9까지 합 : "+sum_9+"\n");
		System.out.println("1부터 10까지 합 : "+sum_10+"\n");
	}
}