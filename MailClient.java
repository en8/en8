package Mms;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MailClient extends Send{	

	public static void main(String[] args){
 	
	         try{	        
	        	 	
	        	 	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));		//  문자 스트림을읽고 버퍼링함 스캐너함수랑비슷함									
	        		String sender,title,content,addressee_array,ip;	
	        		Scanner scan = new Scanner(System.in);
	        		ip = "223.130.121.106";	        		
	        		
	        		Socket clinetsock = new Socket(ip,9407);  		// 포트설정후 사용자들의 아이피설정   223.130.121.106               
	        		
	        		OutputStream outst = clinetsock.getOutputStream();		//  서버의 소켓으로부터 출력을 받음
	                InputStream inst = clinetsock.getInputStream();			//  서버의 소켓으로부터 입력을 받음
	                
	                PrintWriter pw = new PrintWriter(new OutputStreamWriter(outst));        	 //<< 출력 스트림을 변환           
	                BufferedReader br = new BufferedReader(new InputStreamReader(inst));  	// << 입력 스트림을 변환
	               
	                System.out.println("발신자를 입력해주세요.:");
	    			sender = scan.next().trim();
	    			System.out.println("제목을 입력해주세요.:");
	    			title = scan.next();	    			
	    			System.out.println("내용을 입력해주세요.:");
	    			content = scan.next();	    			
	    			System.out.println("수신자의 메일을 입력해주세요 여러명 보낼경우 , 로 구분지어주세요.:");						// 상대방 메일 저장하는 기능
	                addressee_array = scan.next();        
	                                
		            pw.println(sender);                 
	                pw.println(title);							// 서버에 메일의 발신자와수신자 제목,내용보냄
	                pw.println(content);
	                pw.println(addressee_array);
	                     	
	                pw.flush();
	                  
	                br.close();
	                pw.close();
	                clinetsock.close();
	                System.out.println("대량메일 발송 프로그램을 종료합니다.");
	                
	             }catch(Exception e){System.out.println(e);}
	    	 }//  main
     
	} // class Maillclient