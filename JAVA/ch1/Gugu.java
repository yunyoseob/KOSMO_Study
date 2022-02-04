package a.b.c.d;

public class Gugu{
	static int a=1;
	static int b=2;
	static int c=3;
	static int d=4;
	static int e=5;
	static int f=6;
	static int g=7;
	static int h=8;
	static int i=9;

	public static void gugu_num(int num){
		int num_a=num*a;
		int num_b=num*b;
		int num_c=num*c;
		int num_d=num*d;
		int num_e=num*e;
		int num_f=num*f;
		int num_g=num*g;
		int num_h=num*h;
		int num_i=num*i;
		System.out.println("----------"+num+"´Ü--------\n");
		System.out.println(num+"°öÇÏ±â 1Àº : "+num_a+"\n");
		System.out.println(num+"°öÇÏ±â 2Àº : "+num_b+"\n");
		System.out.println(num+"°öÇÏ±â 3Àº : "+num_c+"\n");
		System.out.println(num+"°öÇÏ±â 4Àº : "+num_d+"\n");
		System.out.println(num+"°öÇÏ±â 5Àº : "+num_e+"\n");
		System.out.println(num+"°öÇÏ±â 6Àº : "+num_f+"\n");
		System.out.println(num+"°öÇÏ±â 7Àº : "+num_g+"\n");
		System.out.println(num+"°öÇÏ±â 8Àº : "+num_h+"\n");
		System.out.println(num+"°öÇÏ±â 9Àº : "+num_i+"\n");
	}

	public static void main(String args []){
		Gugu.gugu_num(b);
		Gugu.gugu_num(c);
		Gugu.gugu_num(d);
		Gugu.gugu_num(e);
		Gugu.gugu_num(f);
		Gugu.gugu_num(g);
		Gugu.gugu_num(h);
		Gugu.gugu_num(i);
	}
}