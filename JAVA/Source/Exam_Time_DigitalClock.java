package a.b.c.ch6;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
 
import javax.swing.JFrame;
import javax.swing.JLabel;

// ���߿� �����ϱ� 
// ---- ������ ���� Ŭ���� 
// java.lang.Runnable �������̽� Ŭ����
// java.lang.Thread Ŭ����

// ---- GUI ���� Ŭ���� 
// javax.swing.JFrame �������� Ŭ����
// java.awt.FlowLayout; �÷ο췹�̾ƿ� Ŭ���� 
// java.awt.Font; ��Ʈ Ŭ���� 
// javax.swing.JLabel; ���̶� Ŭ���� 


public class Exam_Time_DigitalClock extends JFrame implements Runnable{

	private Thread thread;
    private JLabel label;
 
    public Exam_Time_DigitalClock(){
        super("������ �ð�");
 
        setLayout(new FlowLayout());
 
        label = new JLabel();
        label.setFont(new Font("Serif",Font.PLAIN, 20));
 
        if(thread == null){
             
            //this�� �ǹ̴� Runnable�� ������ ��ü�� ����(Exam_Time_DigitalClock)
            thread = new Thread(this);
            thread.start();
        }
        add(label);
        setBounds(100,100,400,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void run(){
        while(true){
           
        	Calendar cal = Calendar.getInstance();
            String now = 	cal.get(Calendar.YEAR)+"��"+
		                    (cal.get(Calendar.MONTH)+1)+"��"+
		                    cal.get(Calendar.DATE)+"��"+
		                    cal.get(Calendar.HOUR)+"��"+
		                    cal.get(Calendar.MINUTE)+"��"+
		                    cal.get(Calendar.SECOND)+"��";
            
            label.setText(now);
           
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){               
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
        new Exam_Time_DigitalClock();
	}
}
