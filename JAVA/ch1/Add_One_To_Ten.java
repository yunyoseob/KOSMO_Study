package a.b.c.ch1;

public class Add_One_To_Ten{
	public static int oneS(){
	// �ĺ��� �Լ� �̸��տ� int �ٿ��ص�, int ���� �ְ�, int ���� �����ؾ��Ѵ�.
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
		// �Լ����� return�� ���� int�� ������ sum_n�� �����Ѵ�. 

		System.out.println("1���� 2���� �� : "+sum_2+"\n");
		System.out.println("1���� 3���� �� : "+sum_3+"\n");
		System.out.println("1���� 4���� �� : "+sum_4+"\n");
		System.out.println("1���� 5���� �� : "+sum_5+"\n");
		System.out.println("1���� 6���� �� : "+sum_6+"\n");
		System.out.println("1���� 7���� �� : "+sum_7+"\n");
		System.out.println("1���� 8���� �� : "+sum_8+"\n");
		System.out.println("1���� 9���� �� : "+sum_9+"\n");
		System.out.println("1���� 10���� �� : "+sum_10+"\n");
	}
}