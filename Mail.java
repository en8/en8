package Mms;
import java.util.Date;			
import java.util.Properties;	//���οü����

import javax.mail.Authenticator; 		 
import javax.mail.Message;				// ������ �޼����� �ۼ��� �� ������
import javax.mail.Session;				// ����ó��
import javax.mail.Transport;			// �޼����� ���������� ����
import javax.mail.internet.InternetAddress;			// �����ּ� ���
import javax.mail.internet.MimeMessage;						
import java.util.Scanner;
public class Mail {
							// 	�ڽ��� ���Ϻ���		���� ���Ϻ���			���� ����			���뺯��	Exception���� �ٷΰ�
	public void sendEmail(String myemail, String opponentmail, String title, String content)throws Exception{
		
		
		Properties props = new Properties();
		props.put("mail.transpot.protocol;","smtp"); 			//�������� ����
		props.put("mail.smtp.host","223.130.121.106");		//smtp�ּ� ( ������ �ּ� )
		props.put("mail.smtp.port","25");						//��Ʈ����	
		
		Session mailma = Session.getInstance(props); 	// ���� ������ ����� �� �޽����� �����		
		Message message = new MimeMessage(mailma); // 		mailsen ���� �߼�		
		InternetAddress addr = new InternetAddress(myemail);		// ���� �����»�� ����
		message.setFrom(addr);							// ���� �����»�� ����
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(opponentmail));	// ���Ϲ޴»������	

		message.setSubject(title); 		// ������
		message.setText(content);		// ���뼳��
		Transport.send(message); 		// ������ ����
		System.out.println("���ۼ���");
		
		
		
			} 
	
}


