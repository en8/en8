import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPAddressFailedException;

public class Send extends Thread {
	private MailForm mail;
	private int mail_id;
	
	public Send() { }
	
	public Send(int mail_id) {
		this.mail = new MailForm();
		this.mail_id = mail_id;
	}
	
	public void run() {
		try{
			Properties props = new Properties();
			props.put("mail.transpot.protocol;","smtp");
			props.put("mail.smtp.host", "223.130.121.103");
			props.put("mail.smtp.port","25");
			
			Session session = Session.getInstance(props);
			
			Database db = new Database("127.0.0.1", "3306", "sojt", "root", "1234");
			mail = db.getMailData(this.mail_id);

			if(mail == null) {
				return;
			}
			
			InternetAddress from = new InternetAddress(mail.getFrom());
			Message message = new MimeMessage(session);
			
			for(Recipients v : mail.getTo()) {
				message.setFrom(from);
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(v.getEmail()));
				message.setSubject(mail.getSubject());
				message.setText(mail.getBody());
				try {
					Transport.send(message);
					db.updateMailrecipient(v.getId(), "SENT");
				} catch (SendFailedException sfe) {
					db.updateMailrecipient(v.getId(), "REJECTED");
				}
			}
		
			db.updateMail(this.mail_id);
		} catch(MessagingException me) {
			me.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
