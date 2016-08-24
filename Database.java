import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Database {
	Connection con = null;
	PreparedStatement pstat = null;
	ResultSet res = null;
	
	public Database(String host, String port, String dbname, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/" + dbname + "?autoReconnect=true&useSSL=false" , username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MailForm getMailData(int mail_id) {
		MailForm mailForm = new MailForm();
		
		if(!checkMail(mail_id)){
			return null;
		}
		// 본문 내용 가져오는 부분 
		mailForm = getBody(mailForm, mail_id);
		// 받는 사람 가져오는 부분
		mailForm = getRecipients(mailForm, mail_id);
		
		return mailForm;
	}
	
	public boolean checkMail(int mail_id) {
		String sql = "SELECT COUNT(*) AS `count` FROM `mail` WHERE `id` = ?";
		
		try {
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, mail_id);
			
			res = pstat.executeQuery();
			if(res.next()) {
				if(res.getInt("count") == 0) {
					return false;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public MailForm getBody(MailForm mailForm, int mail_id) {
		String sql = "SELECT `sender_email`, `title`, `body` FROM `mail_body` WHERE `mail_id` = ?";
		try {
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, mail_id);
			
			res = pstat.executeQuery();
			if(res.next()) {
				mailForm.setFrom(res.getString("sender_email"));
				mailForm.setSubject(res.getString("title"));
				mailForm.setBody(res.getString("body"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mailForm;
	}
	
	public MailForm getRecipients(MailForm mailForm, int mail_id) {
		String sql = "SELECT `id`, `email` FROM `mail_recipients` WHERE `mail_id` = ?";
		
		try {
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, mail_id);
			
			res = pstat.executeQuery();
			ArrayList<Recipients> list = new ArrayList<>();
			while(res.next()) {
				list.add(new Recipients(res.getInt("id"), res.getString("email")));
			}
			
			mailForm.setTo(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mailForm;
	}
	
	public void updateMail(int id) {
		String sql = "UPDATE `mail` SET `state` = 'COMPLETED' WHERE id = ?";
		
		try {
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			
			pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMailrecipient(int id, String state) {
		String sql = "UPDATE `mail_recipients` SET `state` = ?, result_time = NOW() WHERE id = ?";
		
		try {
			pstat = con.prepareStatement(sql);
			pstat.setString(1, state);
			pstat.setInt(2, id);
			
			pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
