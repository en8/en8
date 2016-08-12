package Mms;
import java.net.*;
import java.text.SimpleDateFormat; 				// 시간 라이브러리
import java.util.Date;
import java.io.*;


public class MailServer extends Send {

     public static void main(String[] args){
    	 
    	 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	 
    	 try{		
    		 		System.out.println(getTime()+"접속대기중"); 	  
		    		ServerSocket serverport = new ServerSocket(9407);			// 포트 9407번째에 생성
		    		Send mail = new Send();			//		상속받은 클래스 객체생성
		    		
               do{   
            	   
	            	Socket socket = serverport.accept();		//	서버에 접속허락중
	            	
	            	InetAddress inetaddr = socket.getInetAddress();			// 클라이언트의 주소를 가져옴
                    System.out.println(getTime()+inetaddr.getHostAddress()+ " 로부터 접속했습니다.");
                    
                    InputStream inst = socket.getInputStream();             //		<< 클라이언으로부터 바이트 단위로 출력하는 클래스   
                    OutputStream outst = socket.getOutputStream();			// 			<< 클라이언으로부터 바이트단위로 입력하는 클래스

                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(outst));			//<< 출력 스트림을 변환
                    BufferedReader br = new BufferedReader(new InputStreamReader(inst));		// << 입력 스트림을 변환

                    	int j,iman;
                    	String sender,title,content,addressee_array;	

                    	sender	= br.readLine();
                   		title = br.readLine();			//발신자,제목,내용을 클라이언으로부터 입력받음
                   		content = br.readLine();
                   		addressee_array = br.readLine();
                   		iman = br.read();
                   		
                   		String addressee [] = addressee_array.split("[,]");   //  서버에서 받아서 짤라 배열에 저장하기로함
                   		
                   		
                       System.out.println(getTime()+" 전송받은 발신자 : "+sender);
                       System.out.println(getTime()+" 전송받은 제목 : "+title);
                       System.out.println(getTime()+" 전송받은 내용 : "+content);
                       for(j=0;j<iman+1;j++){
                    	   System.out.println(getTime()+"메일보낼 주소목록:"+addressee[j]);
                       		}
                       		System.out.println(getTime()+iman+"명째 보낼준비");

                       mail.sednmail(sender, title, content, addressee);   	// 메일보내는 메서드
                       	System.out.println(getTime()+"메세지 전송완료");
                       	//System.out.println(getTime()+"DB에 저장하시겠습니까? yes/no");
                       	
                       	mail.db_connect(sender,title,content,addressee);		// 메일 DB에 저장하는 메서드
                     
                       	pw.close();
		             	br.close(); 
		             	socket.close();
		             	System.out.println(getTime()+inetaddr.getHostAddress()+"유저가 종료하였습니다.");
		             	
               			}while(true);	             	 
		             		 
             } catch(Exception e){	e.printStackTrace();	}
             
             finally { System.out.println(getTime()+"서버를 종료합니다.");     }   
  
     }					// main
    
}			// Mailservser