package Mms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class Send{
	
	 public static int k;
	
	void db_connect(String sender,String title,String content,String[] addressee)  	{//DB에 저장하는 메소드
				
		try {
			
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println(getTime()+"드라이브 연결성공");	   		// 연결성공@@     	             			            
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sendmail","root", "0000");
			System.out.println(getTime()+"서버 연결성공!"); 				//     서버 연결
			
			for(k=0;k<addressee.length;k++){
			
				String sql = new String("INSERT INTO mailsave (sender, addressee, title, content) VALUES (?, ?, ?, ?)");
				PreparedStatement psmt = conn.prepareStatement(sql); 
				psmt.setString(1, sender);
				psmt.setString(2, addressee[k]);						// << DB에 메일발송 정보 저
				psmt.setString(3, title);
				psmt.setString(4, content);			
				psmt.executeUpdate();
				psmt.clearParameters();									// 클리어 	

						}
			System.out.println(getTime()+"DB저장 완료");
			} catch (Exception e)  {  e.printStackTrace();  }
	
	}
	
	void sednmail(String sender,String title,String content,String[] addressee){ 			// 메일보내는 메소드
		
		try{
			
			String smip = "223.130.121.106";
			Properties props = new Properties();						// 해당 정보를 필요할때만 읽고 사용
			props.put("mail.transpot.protocol;","smtp"); 				// smtp서버 사용
			props.put("mail.smtp.host",smip);							// 호스트 설정
			props.put("mail.smtp.port","25");							// 포트설정 
			Session mailma = Session.getInstance(props); 				// 정보를 가지고있게함
			
			for(k=0;k<addressee.length;k++){
				
				Message message = new MimeMessage(mailma); 				// 		mailsen 객체생성
				InternetAddress addr = new InternetAddress(sender);				
				message.setFrom(addr);									// 발신자 수신
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(addressee[k]));	// 메일수신자
				message.setSubject(title); 								// 제목설정
				message.setText(content);								// 내용설정
				Transport.send(message);								// 메세지전송
				
				}
		
		}catch(Exception e)  {  e.printStackTrace();  }
		
	}
	
	static String getTime(){
		
        SimpleDateFormat time = new SimpleDateFormat("[hh:mm:ss]"); 	// 간단하게 사용할수있도록 함>> 날짜 출력 h=시  m=분  s=초
        return time.format(new Date());
        
    }

}