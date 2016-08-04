package Mms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class Smtp extends DB{
	
	void SendM(){
		try{
			
			Properties props = new Properties();
			props.put("mail.transpot.protocol;","smtp"); 			// smtp서버 사용
			props.put("mail.smtp.host","223.130.121.106");		// 		호스트 설정
			props.put("mail.smtp.port","25");						//	포트설정 
			Session mailma = Session.getInstance(props); 	
			Message message = new MimeMessage(mailma); // 		mailsen 객체생성
			
			InternetAddress addr = new InternetAddress(sender);			// 발신자 수신
			message.setFrom(addr);							
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(addressee));	//메일전송
			message.setSubject(title); 				// 제목설정
			message.setText(content);				// 내용설정
			Transport.send(message);			// 	메일 발송
			
		}catch(Exception e){}
	}
}