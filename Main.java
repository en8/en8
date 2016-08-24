import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		try {
			ServerSocket listener = new ServerSocket(8282);
			while(true) {
				Socket socket = listener.accept();
				
				System.out.println("Mail Send Server Start Port : 8282");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				int mail_id = Integer.parseInt(in.readLine());
				
				Send send = new Send(mail_id);
				send.start();
				
				socket.close();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
