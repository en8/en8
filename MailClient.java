package Mms;
import java.net.*;
import java.util.Properties;
import java.io.*;

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
 

public class MailClient extends Send{
	
	  public static boolean getYesNoKey() {

	
     public static void main(String[] args){

         try{
        	 	String sender,title,content;	 
        		Scanner scan = new Scanner(System.in);
                   
        		System.out.println("시작할래? yes/no");
        		if(scan.hasNext())
        		System.out.println("대량메일발송서비스야");
        		System.out.println("");
                
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		Socket serversock = new Socket("127.0.0.1", 10001);  		// 포트설정후 사용자들의 아이피설정                  
                BufferedReader sock = new BufferedReader(new InputStreamReader(System.in)); 	//  문자 스트림을읽고 버퍼링함 스캐너함수랑비슷함
                //  생성된 Socket으로부터 InputStream과 OutputStream을 구함 
                  

    			System.out.print("발신자의 메일을 입력해주세요..:");           
    	        sender=scan.next().trim();	        
    	    	System.out.println("제목을 입력해주세요.:");
    	 		title=scan.next();  		 		 // 발신자,수신자 등 메일에 관한 정보 입력받기
    	 		System.out.println("내용을 입력해주세요.:");
    	 		content=scan.next();
  		 		
  			 		
                  
                  OutputStream outst = serversock.getOutputStream();		//  서버의 소켓으로부터 출력을 받음
                  InputStream inst = serversock.getInputStream();			//  서버의 소켓으로부터 입력을 받음                                                     

                  PrintWriter pw = new PrintWriter(new OutputStreamWriter(outst));        	 //<< 출력 스트림을 변환           
                  BufferedReader br = new BufferedReader(new InputStreamReader(inst));  	// << 입력 스트림을 변환
                                   
                  String line = null;           
                  System.out.println("종료하실때는 exit를 입력해주세요");
                  
                  while((line = sock.readLine())!= null){
                      	if(line.equals("exit"))break;                      	
                      	pw.println(line);                  
                        pw.flush();      
                    }
                  
                    pw.close();
                    br.close();
                    serversock.close();
                    System.out.println("대량메일 발송 프로그램을 종료합니다.안녕히 가십시오.");                    
             }catch(Exception e){
                    System.out.println(e);
             }
       }
     
} // class Maillclient
