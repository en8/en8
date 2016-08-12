package Mms;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MailClient extends Send{
	// iman과 j input,scan은 전역변수로 선언하는걸 고려해봐야함  ,다만 sender,title,content,addressee은 계속사용하니 전역변수로 선언
	

	public static void main(String[] args){
 	 
	         try{	        
	        	 	
	        	 	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));		//  문자 스트림을읽고 버퍼링함 스캐너함수랑비슷함
	        		int iman;									
	        		String sender,title,content,addressee_array,answer;	
	        		Scanner scan = new Scanner(System.in);
	        	 
	        		Socket clinetsock = new Socket("223.130.121.106", 9407);  		// 포트설정후 사용자들의 아이피설정   223.130.121.106               
	        		
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
	    			System.out.print("몇명에게 보내시겠습니까?"); 
	    			while(!scan.hasNextInt()){
	    				scan.next();										// 몇명보낼지 정하는기능
	    		        System.out.println("숫자를 입력해주세요!");
	    		        }iman =scan.nextInt();	    			
	    			System.out.println("수신자의 메일을 입력해주세요 여러명 보낼경우 , 로 구분지어주세요.:");						// 상대방 메일 저장하는 기능
	                addressee_array = scan.next();	        
	  
		              	  pw.println(sender);                 
	                      pw.println(title);							// 서버에 메일의 발신자와수신자 제목,내용보냄
	                      pw.println(content);
	                      pw.println(addressee_array);
	                      pw.print(iman);
	                     	
	                      pw.flush();
	                  
	                      br.close();
	                      pw.close();
	                    clinetsock.close();
	                    System.out.println("대량메일 발송 프로그램을 종료합니다.");                    
	             }catch(Exception e){System.out.println(e);}
	    	 }//  main
     
	} // class Maillclient