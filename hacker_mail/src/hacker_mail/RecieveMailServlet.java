package hacker_mail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;  
import java.util.Properties;  
import javax.mail.Folder;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.NoSuchProviderException;  
import javax.mail.Session;  
import com.sun.mail.pop3.POP3Store;
@WebServlet("/inbox")
public class RecieveMailServlet extends HttpServlet {
	public static void receiveEmail(String pop3Host, String storeType,  
			  String user, String password) {  
			  try {  
			   //1) get the session object  
			   Properties properties = new Properties();  
			   properties.put("mail.pop3.host", pop3Host);  
			   Session emailSession = Session.getDefaultInstance(properties);  
			     
			   //2) create the POP3 store object and connect with the pop server  
			   POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);  
			   emailStore.connect(user, password);  
			  
			   //3) create the folder object and open it  
			   Folder emailFolder = emailStore.getFolder("INBOX");  
			   emailFolder.open(Folder.READ_ONLY);  
			  
			   //4) retrieve the messages from the folder in an array and print it  
			   Message[] messages = emailFolder.getMessages();  
			   for (int i = 0; i < messages.length; i++) {  
			    Message message = messages[i];  
			    System.out.println("---------------------------------");  
			    System.out.println("Email Number " + (i + 1));  
			    System.out.println("Subject: " + message.getSubject());  
			    System.out.println("From: " + message.getFrom()[0]);  
			    System.out.println("Text: " + message.getContent().toString());  
			   }  
			  
			   //5) close the store and folder objects  
			   emailFolder.close(false);  
			   emailStore.close();  
			  
			  } catch (NoSuchProviderException e) {e.printStackTrace();}   
			  catch (MessagingException e) {e.printStackTrace();}  
			  catch (IOException e) {e.printStackTrace();}  
			 }  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String host = "Pop.gmail.com";//change accordingly  
		  String mailStoreType = "pop3";  
		  String username= "azam20104u@gmail.com";  
		  String password= "azam.dev05";//change accordingly  	  
		  receiveEmail(host, mailStoreType, username, password);  
	}
}
