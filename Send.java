package Mms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Send {
			
	public static void main(String[] args) {
					
			try {
					
					int i,k,j;   						// ���Ϻ������� ����
					String myemail,title,content; 		//�ڽ��� �����ּ�	,������ �����ּ�,���� ����,���� ����
					String opponentmail = null;

					Properties props = new Properties();
		    		props.put("mail.transpot.protocol;","smtp"); 			//�������� ����
		    		props.put("mail.smtp.host","223.130.121.106");		//smtp�ּ� ( ������ �ּ� )
		    		props.put("mail.smtp.port","25");						//��Ʈ����					
					Session mailma = Session.getInstance(props); 	// ���� ������ ����� �� �޽����� �����
					Message message = new MimeMessage(mailma); // 		mailsen ���� �߼�		
					Class.forName("org.gjt.mm.mysql.Driver");			//DB����̹� �� �ڹ� �ε�
					System.out.println("DB�� Driver �ε�����"); 
					//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "en8", "ansanwls1#");				//DB�͸����� ����
					Scanner scan = new Scanner(System.in);                  
			        System.out.print("�ڽ��� e-mail�� �Է����ּ���.:");           
			        myemail = scan.next();
			        myemail=myemail.trim();
					System.out.print("����� �����ðڽ��ϱ�?");
			    	i =scan.nextInt();		    	
			    	System.out.println("������ �Է����ּ���.:");
		    		title=scan.next();
		    		System.out.println("������ �Է����ּ���.:");
		    		content=scan.next();
		    		
					 for(j=1;j<=i;j++){ 	
						 	InternetAddress addr = new InternetAddress(myemail);			// ���� �����»�� ����
				        	System.out.println("���濡"+j+"��° e-mail�� �Է����ּ���.:");
				    		opponentmail=scan.next();
				    		opponentmail=opponentmail.trim();				    		
				    		for(int a=1;a<=j;a++){
				    			message.setFrom(addr);							// ���� �����»�� ����
				    			message.addRecipient(Message.RecipientType.TO,new InternetAddress(opponentmail));	// ���Ϲ޴»������	
				    			message.setSubject(title); 		// ������
				    			message.setText(content);		// ���뼳��
				    			Transport.send(message);				// ������ ����
		    		
				    		}
				}    			

			    		
			    		System.out.println("���ۼ���");			//@@@@ ������ �߰� ���� @@@@ + �ð��߰�
			    		
					}
			
			catch(Exception e){
				System.out.println("�������");
				
			}
			
		}
				
}