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
	String sender,title,content;	 
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
	// 사람들 정보
	void info(){
		
			
	}
	
	
	
		public static void main(String[]args){
			
			try{
				
				Scanner scan = new Scanner(System.in);

	        	
	        	
	        	
				Properties props = new Properties();
    			props.put("mail.transpot.protocol;","smtp"); 			// smtp서버 사용
    			props.put("mail.smtp.host","223.130.121.106");		// 		호스트 설정
    			props.put("mail.smtp.port","25");		
    			  
    			Class.forName("org.gjt.mm.mysql.Driver");
  				System.out.println("드라이브 연결성공");	   		// 연결성공문은 서버로 보내기 @@     	             			            
  				Connection conn = DriverManager.getConnection("jdbc:mysql://223.130.121.106/sendmail","root", "0000");
  				System.out.println("서버 연결성공!"); //     서버 연결 

  				
					
			
				
		}
			
			catch(Exception e){
				e.printStackTrace();
			}				
				
}
	
}