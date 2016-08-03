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
	static Scanner scan = new Scanner(System.in);
	static String sender,title,content,addressee =null;
	static int i,j;

	

	static class info extends Thread{	
		
		public void run() {	
			
			System.out.print("발신자의 메일을 입력해주세요..:");           
	        sender=scan.next().trim();
	        System.out.print("몇명에게 보내시겠습니까?");
	        while(!scan.hasNextInt()){
	        scan.next();
	        System.out.println("숫자를 입력해주세요!");
	        }i =scan.nextInt();   											// 발신자,수신자 등 메일에 관한 정보 입력받기    
	    	System.out.println("제목을 입력해주세요.:");
	 		title=scan.next();
	 		System.out.println("내용을 입력해주세요.:");
	 		content=scan.next();	
		 		
		}	
}			
	
		public static void main(String[]args){
			
			try{
			info inf = new info();
			inf.start();
			inf.join();

			Properties props = new Properties();
			props.put("mail.transpot.protocol;","smtp"); 			// smtp서버 사용
			props.put("mail.smtp.host","223.130.121.106");		// 		호스트 설정
			props.put("mail.smtp.port","25");						//	포트설정 
			Session mailma = Session.getInstance(props); 	
			Message message = new MimeMessage(mailma); // 		mailsen 객체생성
			
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이브 연결성공");	        	             			            
			Connection conn = DriverManager.getConnection("jdbc:mysql://223.130.121.106/sendmail","root", "0000");
			System.out.println("서버 연결성공!"); //     서버 연결 
    
		for(j=1;j<=i;j++) {	
			System.out.println("상대방의"+j+"번째 메일을 입력해주세요.:");
			addressee=scan.next().trim();
		
			InternetAddress addr = new InternetAddress(sender);			// 발신자 수신
			message.setFrom(addr);							
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(addressee));	//메일전송
			message.setSubject(title); 				// 제목설정
			message.setText(content);				// 내용설정
			Transport.send(message);			// 	메일 발송
											
			String sql = new String("INSERT INTO mailsave (sender, addressee, title, content) VALUES (?, ?, ?, ?)");
			PreparedStatement psmt = conn.prepareStatement(sql); 
			psmt.setString(1, sender);
			psmt.setString(2, addressee);				// << DB에 메일발송 정보 저
			psmt.setString(3, title);
			psmt.setString(4, content);					
			psmt.executeUpdate();
			psmt.clearParameters();					// 클리어 
		}	
			System.out.println("전송성공!");	
			}
			catch(Exception e){
				e.printStackTrace();
			}				
				
}
	
}