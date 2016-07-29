package Mms;
import java.util.Date;			
import java.util.Properties;	//새로운객체생성

import javax.mail.Authenticator; 		 
import javax.mail.Message;				// 메일의 메세지를 송수신 등 가능함
import javax.mail.Session;				// 메일처리
import javax.mail.Transport;			// 메세지를 최종적으로 전달
import javax.mail.internet.InternetAddress;			// 메일주소 사용
import javax.mail.internet.MimeMessage;						
import java.util.Scanner;
public class Mail {
							// 	자신의 메일변수		상대방 메일변수			제목 변수			내용변수	Exception으로 바로감
	public void sendEmail(String myemail, String opponentmail, String title, String content)throws Exception{
		
		
		Properties props = new Properties();
		props.put("mail.transpot.protocol;","smtp"); 			//프로토콜 설정
		props.put("mail.smtp.host","223.130.121.106");		//smtp주소 ( 리눅스 주소 )
		props.put("mail.smtp.port","25");						//포트설정	
		
		Session mailma = Session.getInstance(props); 	// 메일 세션을 만들고 빈 메시지를 만든다		
		Message message = new MimeMessage(mailma); // 		mailsen 메일 발송		
		InternetAddress addr = new InternetAddress(myemail);		// 메일 보내는사람 설정
		message.setFrom(addr);							// 메일 보내는사람 설정
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(opponentmail));	// 메일받는사람설정	

		message.setSubject(title); 		// 제목설정
		message.setText(content);		// 내용설정
		Transport.send(message); 		// 메일을 보냄
		System.out.println("전송성공");
		
		
		
			} 
	
}


