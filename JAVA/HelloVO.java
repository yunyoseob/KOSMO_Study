package a.b.c.ch3;

public class HelloVO {
	
	private String mid;
	private String mpw;
	private String mname;
	//  private ���������ڴ� class ���� ����� ���Ѵ�.
	// public �����ڸ� �����, thisŰ���带 ���� 
	// �ܺο��� ��밡���ϵ��� �Ѵ�. (������ ����ȭ)
	
	public HelloVO() {
		//super();
	} // �⺻ ������

	public HelloVO(String mid, String mpw, String mname) {
		//super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
	} // �Ű������� �ִ� ������
	
	// getter method
	public String getMid() {
		return mid;
		// ������ mid ������ return ������ ��ȯ�Ѵ�.
	} 
	public String getMpw() {
		return mpw;
		// ������ mpw ������ return ������ ��ȯ�Ѵ�.
	}
	public String getMname() {
		return mname;
		// ������ mname ������ return ������ ��ȯ�Ѵ�.
	}
	
	// setter method
	public void setMid(String mid) {
		this.mid = mid;
		// ���� HelloVO Ŭ������ private String mid�� �Ű������� ���� �μ��� �ʱ�ȭ ��,
		// mid�� �����Ѵ�.
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
		// ���� HelloVO Ŭ������  private String mpw�� �Ű������� ���� �μ��� �ʱ�ȭ ��,
		// mpw�� �����Ѵ�.
	}
	public void setMname(String mname) {
		this.mname = mname;
		// ���� HelloVO Ŭ������  private String mname�� �Ű������� ���� �μ��� �ʱ�ȭ ��,
		// mname�� �����Ѵ�.
	}
	
}
