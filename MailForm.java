import java.util.ArrayList;

public class MailForm {
	private String from;
	private ArrayList<Recipients> to;
	private String subject;
	private String body;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public ArrayList<Recipients> getTo() {
		return to;
	}
	public void setTo(ArrayList<Recipients> to) {
		this.to = to;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}

class Recipients {
	private int id;
	private String email;
	
	public Recipients(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}