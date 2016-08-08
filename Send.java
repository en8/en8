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

public class Send{
	static String sender,title,content;	 
	Scanner scan = new Scanner(System.in);
	
	
	// i 명 만큼 보낼 사람인원수	
	void iman(){
		
			int i,j;				
	        System.out.print("몇명에게 보내시겠습니까?");  		        
	        while(!scan.hasNextInt()){
	        scan.next();
	        System.out.println("숫자를 입력해주세요!");			
	        }i =scan.nextInt();        
	        String addressee [] = new String[i];    	
    	for(j=0;j<=i;j++){					
			System.out.println("상대방의"+(j++)+"번째 메일을 입력해주세요.:"); // 상대방 메일 저장하는 기능
			addressee[j]=scan.next().trim();
						 	}
    	
				}
	
	
	// 메일전송하고 db에 저장하는기능
	void sendsave(String addressee[]){
		
		try{
			
			int j;
			Properties props = new Properties();
			props.put("mail.transpot.protocol;","smtp"); 			// smtp서버 사용
			props.put("mail.smtp.host","223.130.121.106");		// 		호스트 설정
			props.put("mail.smtp.port","25");						//	포트설정 
			Session mailma = Session.getInstance(props); 	
			Message message = new MimeMessage(mailma); // 		mailsen 객체생성
			
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이브 연결성공");	   		// 연결성공문은 서버로 보내기 @@     	             			            
			Connection conn = DriverManager.getConnection("jdbc:mysql://223.130.121.106/sendmail","root", "0000");
			System.out.println("서버 연결성공!"); //     서버 연결 
			
						
			for(j=0;j<=addressee.length;j++){
			
			InternetAddress addr = new InternetAddress(sender);			// 발신자 수신
			message.setFrom(addr);							
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(addressee[j]));	// 메일수신자
			message.setSubject(title); 				// 제목설정
			message.setText(content);				// 내용설정
			Transport.send(message);			// 	메일 발송
			
			
			String sql = new String("INSERT INTO mailsave (sender, addressee, title, content) VALUES (?, ?, ?, ?)");
			PreparedStatement psmt = conn.prepareStatement(sql); 
			psmt.setString(1, sender);
			psmt.setString(2, addressee[j]);				// << DB에 메일발송 정보 저
			psmt.setString(3, title);
			psmt.setString(4, content);					
			psmt.executeUpdate();
			psmt.clearParameters();					// 클리어 
			
			}
			System.out.println("전송완료");
		}catch(Exception e){}
	}
	

}
