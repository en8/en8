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
			
			Class.forName("org.gjt.mm.mysql.Driver");			//DB����̹� �� �ڹ� �ε�
			System.out.println("DB�� Driver �ε�����"); 
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "en8", "ansanwls1#");				//DB�͸����� ����
			Scanner scan = new Scanner(System.in);                  
	        System.out.print("�ڽ��� e-mail�� �Է����ּ���.:");           
	        myemail = scan.next();
	        myemail=myemail.trim();
	        System.out.print("������ ���κ�����? yes=1 no=2");   
	        k = scan.nextInt(); 
	        if(k==1)
	        {
	        	System.out.print("����� �����ðڽ��ϱ�?");
	        	i =scan.nextInt();
	        for(j=0;j<=i-1;j++){            	
	        	System.out.println((j+1)+"��° e-mail�� ������ e-mail�� �Է����ּ���.:");
	        	
	    		opponentmail=scan.next();
	    		opponentmail=opponentmail.trim();
	    		mailarray[j]=opponentmail;
      		}            
            
        } 	
        else{
        	
        }           
            
            // ����,�̸�,����,����,e-mail,ip�� ����� DB�� �����Ŵ
            // ip���ܽ� ip ��ȸ�Ͽ� �ٽ� ������
            // �Ȱ��� ����鿡�� �ٸ� ������ �ٽ� ������
            // ��) ���̰� 17�� �̻��λ�����Ը� �� ������ ������ʹ�.
            // ���Ϻ�����
            			
		} 
		catch (Exception e){
			System.out.println("�������");		 
			e.printStackTrace();
			}
		
			
		}

}