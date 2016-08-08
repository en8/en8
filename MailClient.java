package Mms;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class MailClient {

	
     public static void main(String[] args){

    	
	         try{
	        	 	String sender,title,content,addressee;	 
	        	 	
	        		Socket clinetsock = new Socket("127.0.0.1", 9407);  		// 포트설정후 사용자들의 아이피설정                  
	        		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 	//  문자 스트림을읽고 버퍼링함 스캐너함수랑비슷함
	        		Scanner scan = new Scanner(System.in);

	                  OutputStream outst = clinetsock.getOutputStream();		//  서버의 소켓으로부터 출력을 받음
	                  InputStream inst = clinetsock.getInputStream();			//  서버의 소켓으로부터 입력을 받음                                                     
	
	                  PrintWriter pw = new PrintWriter(new OutputStreamWriter(outst));        	 //<< 출력 스트림을 변환           
	                  BufferedReader br = new BufferedReader(new InputStreamReader(inst));  	// << 입력 스트림을 변환
	                  
	                
	                  System.out.println(" 대량메일의 정보를 입력해주세요.종료할떄는 trd 를 쳐주세요.");   		// 수고요 => ㅅㄱㅇ  => trd 
	                  
	                      //if(input.equals("trd")) break;
	                      System.out.println("발신자메일을 입력해주세요.:");
	                      sender = input.readLine();
	                      System.out.println("제목을 입력해주세요.");				// 메일의 발신자와 제목,내용 입력
	                      title = input.readLine();
	                      System.out.println("내용을 입력해주세요.:");
	                      content = input.readLine();
	                      int iman,j;
	                      
		          	        System.out.print("몇명에게 보내시겠습니까?");  		        
		          	        while(!scan.hasNextInt()){
		          	        scan.next();
		          	        System.out.println("숫자를 입력해주세요!");			
		          	        }iman =scan.nextInt();
		          	        
		          	        	
		              	for(j=0;j<=iman;j++){					
		          			System.out.println("상대방의"+(j++)+"번째 메일을 입력해주세요.:"); // 상대방 메일 저장하는 기능
		          				addressee=input.readLine().trim();
		          				pw.print(addressee);
		          						 	}
		              	
		              	  pw.println(sender);                 
	                      pw.println(title);							// 서버에 메일의 발신자와수신자 제목,내용보냄
	                      pw.println(content);
	                      pw.print(iman);
	                      
	                      pw.flush();

	                      br.close();
	                      pw.close();
	                    clinetsock.close();
	                    System.out.println("대량메일 발송 프로그램을 종료합니다.안녕히 가십시오.");                    
	             }catch(Exception e){System.out.println(e);}
	    	 }
	     
	} // class Maillclient