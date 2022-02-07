package a.b.c.ch1;

public class Var_practice_2{
	void charMethod(){
		System.out.println("�����ڷ��� char �� Wrapper Ŭ���� Character");
        System.out.println("char 2byte(�������� 16bit, ���ڸ� �ٷ�� ������ ������ ���� �� ����.)");

        // BYTES, MAX_VALUE, MIN_VALEU, SIZE �ֿܼ� ����ϱ�
        // public static final int      BYTES
        // int charBytes = java.lang.Character.BYTES;
        int charBytes = Character.BYTES;
        // public static final char MAX_VALUE
        // char charMaxValue = java.lang.Character.MAX_VALUE;
        char charMaxValue = Character.MAX_VALUE;
        // public static final char MIN_VALUE   l
        // char charMinValue = java.lang.Character.MIN_VALUE;
        char charMinValue = Character.MIN_VALUE;
        // public static final int      SIZE
        // int charSize = java.lang.Character.SIZE;
        int charSize = Character.SIZE;

        System.out.println("charBytes >>> : " + charBytes);
		// 2
        System.out.println("charMaxValue >>> : " + charMaxValue);
		// ?���� ��µ�. ������ '(\)uFFF'���� ���;� �ϴµ�
		// MS DOS(�ܼ�â)�� '(\)uFFF'�� ������ ���ؼ� ?���� ��µ�.
        System.out.println("charMinValue >>> : " + charMinValue);
		// �ƹ� �͵� ��µ��� ����. ������ '\u0000'���� ���;� �ϴµ�
		// MS DOS(�ܼ�â)�� '\u0000'�� ������ ���ؼ� �ƹ��͵� ��µ��� ����.
        System.out.println("charSize >>> : " + charSize);
		// 16�� �����µ�, char�� 16��Ʈ(2����Ʈ)�̱� ����

        int charMaxValue_1 = Character.MAX_VALUE;
        int charMinValue_1 = Character.MIN_VALUE;
        System.out.println("charMaxValue_1 >>> : " + charMaxValue_1);
		// int������ �������ָ� 65535�� ��µ�.
        System.out.println("charMinValue_1 >>> : " + charMinValue_1);
		// int������ �������ָ� 0�� ��µ�.

		char charMin = '\u0000'; // �����ڵ�
        char charMax = '\uFFFF'; // �����ڵ�
        System.out.println("charMin >>> : " + charMin);
		// �����ڵ�� ����ϸ� ���������� �ƹ��͵� ��µ��� ����.
        System.out.println("charMax >>> : " + charMax);
		// �����ڵ�� ����ϸ� ���������� ?���� ��µ�.
        char charinitialization  = ' '; // char ������ Ÿ���� �� ���ڿ�, �̱� �����̼����� �ʱ�ȭ �Ѵ�.
        System.out.println("charinitialization >>> : " + charinitialization);
		// ' '�� �ǹ̴� ����� ���̴�.
	}

		public static void main(String args[]){
			new Var_practice_2().charMethod();
		}
} // end of Var_practice_2

/*
cmd(ms dos)�� window powershell ��� ���� ����� ����.

�����ڷ��� char �� Wrapper Ŭ���� Character
char 2byte(�������� 16bit, ���ڸ� �ٷ�� ������ ������ ���� �� ����.)
charBytes >>> : 2
charMaxValue >>> : ?
charMinValue >>> :
charSize >>> : 16
charMaxValue_1 >>> : 65535
charMinValue_1 >>> : 0
charMin >>> :
charMax >>> : ?
charinitialization >>> :
*/