package studyviral.in;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {
	private String userEmail;
	private String myHash;

	public String getUserEmail() {
		return userEmail;
	}

	public SendingEmail(String userEmail, String myHash) {
		this.userEmail = userEmail;
		this.myHash = myHash;
	}

	public void sendMail() {
		String email = "tamjaime6@gmail.com";
		String pword = "j@ime123";
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, pword);

			}

		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("StudyViral.in Email Verification Link");
			message.setText("Verification Link...");
			message.setText("Your Verification Link :: "
					+ "http://localhost:8084/practicaDespliegue/ActivateAccount?key1=" + userEmail + "&key2=" + myHash);
			Transport.send(message);

		} catch (Exception ex) {
			System.out.println("Sending Email...." + ex);
		}

	}
}
