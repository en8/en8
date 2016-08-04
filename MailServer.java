package Mms;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class MailServer {

       public static void main(String[] args){

             try{
                    ServerSocket serverport = new ServerSocket(10001); 			// 포트 9407번째에 생성
                    System.out.println(getTime()+"접속대기중");
                    Socket socket = serverport.accept(); 		//	서버에 접속허락중
                    
                    InetAddress inetaddr = socket.getInetAddress();			// 클라이언트의 주소를 가져옴
                    System.out.println(getTime()+inetaddr.getHostAddress()+ " 로부터 접속했습니다.");
                    
                    InputStream inst = socket.getInputStream();             //		<< 클라이언으로부터 바이트 단위로 출력하는 클래스   
                    OutputStream outst = socket.getOutputStream();			// 			<< 클라이언으로부터 바이트단위로 입력하는 클래스

                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(outst));
                    BufferedReader br = new BufferedReader(new InputStreamReader(inst));	//BufferedReader는 버퍼에 저장된 스트림을  라인째읽음	
                   
                    
                    String line = null; 
                    while((line = br.readLine()) != null){
                           System.out.println(getTime()+"클라이언트로부터 전송받은 문자:"+line);
                           pw.println(line); 		// 서버로 다시 보냄
                           pw.flush();
                    }
                    br.close(); 				
                    socket.close();					// << 작업 종료
                    pw.flush();
                    System.out.println("서버가 종료하였습니다."); //   꼭 어느 사용자가 종료했는지 뜨게하기
             } catch(Exception e){
                    System.out.println(e);
             }
       }
       static String getTime(){
           SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]"); //날짜 출력
           return f.format(new Date());
       }
       
}