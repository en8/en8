package Mms;
import java.net.*;
import java.text.SimpleDateFormat; 				// 시간 라이브러리
import java.util.Date;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
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

public class MailServer extends Send {

       public static void main(String[] args){
    	   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	  // while(true){
    		   
             try{	
            	 	//if(input.equals("trd")) break;  
                    ServerSocket serverport = new ServerSocket(9407); 			// 포트 9407번째에 생성
                    System.out.println(getTime()+"접속대기중");
                    Socket socket = serverport.accept(); 		//	서버에 접속허락중
                    
                    InetAddress inetaddr = socket.getInetAddress();			// 클라이언트의 주소를 가져옴
                    System.out.println(getTime()+inetaddr.getHostAddress()+ " 로부터 접속했습니다.");
                    
                    InputStream inst = socket.getInputStream();             //		<< 클라이언으로부터 바이트 단위로 출력하는 클래스   
                    OutputStream outst = socket.getOutputStream();			// 			<< 클라이언으로부터 바이트단위로 입력하는 클래스

                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(outst));			//<< 출력 스트림을 변환
                    BufferedReader br = new BufferedReader(new InputStreamReader(inst));		// << 입력 스트림을 변환

                    	int iman,j;
                    	String sender,title,content;
                    	
                    	iman = br.read();
                    	String addressee []	= new String[iman];
                    	
                    	sender	= br.readLine();
                   		title = br.readLine();			//발신자,제목,내용을 클라이언으로부터 입력받음
                   		content = br.readLine();
                   		
                       System.out.println(getTime()+"클라이언트로부터 전송받은 발신자 : "+sender);
                       System.out.println(getTime()+"클라이언트로부터 전송받은 제목 : "+title);
                       System.out.println(getTime()+"클라이언트로부터 전송받은 내용 : "+content);
                       
                       for(j=0;j<=iman;j++){
                    	  //addressee [j] = br.read();
                       }
                       
	                   pw.close();
	                   br.close();
	                   socket.close();

             
                    System.out.println(inetaddr.getHostAddress()+"유저가 종료하였습니다.");
                    
             } catch(Exception e){	e.printStackTrace();	}
             
             finally { System.out.println("서버가 종료하였습니다.");  }
    	   }
//}
       
       static String getTime(){
           SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]"); //날짜 출력
           return f.format(new Date());
       }
       
}