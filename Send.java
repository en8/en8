package Mms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Send {
			
	public static void main(String[] args) {
					
			try {
					
					int i,k,j;   						// 메일보낼갯수 변수
					String myemail,title,content; 		//자신의 메일주소	,상대방의 메일주소,메일 제목,메일 내용
					String opponentmail = null;

					Properties props = new Properties();
		    		props.put("mail.transpot.protocol;","smtp"); 			//프로토콜 설정
		    		props.put("mail.smtp.host","223.130.121.106");		//smtp주소 ( 리눅스 주소 )
		    		props.put("mail.smtp.port","25");						//포트설정					
					Session mailma = Session.getInstance(props); 	// 메일 세션을 만들고 빈 메시지를 만든다
					Message message = new MimeMessage(mailma); // 		mailsen 메일 발송		
					Class.forName("org.gjt.mm.mysql.Driver");			//DB드라이버 와 자바 로딩
					System.out.println("DB에 Driver 로딩성공"); 
					//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "en8", "ansanwls1#");				//DB와리눅스 연결
					Scanner scan = new Scanner(System.in);                  
			        System.out.print("자신의 e-mail을 입력해주세요.:");           
			        myemail = scan.next();
			        myemail=myemail.trim();
					System.out.print("몇명에게 보내시겠습니까?");
			    	i =scan.nextInt();		    	
			    	System.out.println("제목을 입력해주세요.:");
		    		title=scan.next();
		    		System.out.println("내용을 입력해주세요.:");
		    		content=scan.next();
		    		
					 for(j=1;j<=i;j++){ 	
						 	InternetAddress addr = new InternetAddress(myemail);			// 메일 보내는사람 설정
				        	System.out.println("상대방에"+j+"번째 e-mail을 입력해주세요.:");
				    		opponentmail=scan.next();
				    		opponentmail=opponentmail.trim();				    		
				    		for(int a=1;a<=j;a++){
				    			message.setFrom(addr);							// 메일 보내는사람 설정
				    			message.addRecipient(Message.RecipientType.TO,new InternetAddress(opponentmail));	// 메일받는사람설정	
				    			message.setSubject(title); 		// 제목설정
				    			message.setText(content);		// 내용설정
				    			Transport.send(message);				// 메일을 보냄
		    		
				    		}
				}    			

			    		
			    		System.out.println("전송성공");			//@@@@ 전송중 추가 예정 @@@@ + 시간추가
			    		
					}
			
			catch(Exception e){
				System.out.println("연결실패");
				
			}
			
		}
				
}