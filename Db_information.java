package Mms;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import java.util.Scanner;

public class Db_information {
		
	public static void Sendamail(){
  
	}
	public static void main(String[]ares){
		int i,k,j;
		String myemail,opponentmail;
		String [] mailarray = new String [50];
		

		
		try{
			
			Class.forName("org.gjt.mm.mysql.Driver");			//DB드라이버 와 자바 로딩
			System.out.println("DB에 Driver 로딩성공"); 
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "en8", "ansanwls1#");				//DB와리눅스 연결
			Scanner scan = new Scanner(System.in);                  
	        System.out.print("자신의 e-mail을 입력해주세요.:");           
	        myemail = scan.next();
	        myemail=myemail.trim();
	        System.out.print("메일을 새로보냄ㅇ? yes=1 no=2");   
	        k = scan.nextInt(); 
	        if(k==1)
	        {
	        	System.out.print("몇명에게 보내시겠습니까?");
	        	i =scan.nextInt();
	        for(j=0;j<=i-1;j++){            	
	        	System.out.println((j+1)+"명째 e-mail중 상대방의 e-mail을 입력해주세요.:");
	        	
	    		opponentmail=scan.next();
	    		opponentmail=opponentmail.trim();
	    		mailarray[j]=opponentmail;
      		}            
            
        } 	
        else{
        	
        }           
            
            // 순서,이름,나이,성별,e-mail,ip을 만들어 DB에 저장시킴
            // ip차단시 ip 우회하여 다시 보내기
            // 똑같은 사람들에게 다른 내용을 다시 보낼때
            // 예) 나이가 17살 이상인사람에게만 이 메일을 보내고싶다.
            // 메일보내기
            			
		} 
		catch (Exception e){
			System.out.println("연결실패");		 
			e.printStackTrace();
			}
		
			
		}

}