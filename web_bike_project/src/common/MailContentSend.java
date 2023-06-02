package common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailContentSend {
	private String SMPT_HOSTNAME;
	private String USERNAME;
	private String PASSWORD;	
	
	public void setMail(String host, String user,String password) {
		this.SMPT_HOSTNAME = host;
		this.USERNAME = user;
		this.PASSWORD = password;
	}
	public void sendMail(String fromName,String fromMailAddr,String toMailAddr,String title, String content) throws Exception{
	   Properties props = new Properties();
	   props.put("mail.smtp.host", SMPT_HOSTNAME);
	   props.put("mail.from",fromMailAddr);
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	   Session session = Session.getInstance(props, new Authenticator() {
		   @Override
		   protected PasswordAuthentication getPasswordAuthentication() {
			   return new PasswordAuthentication(USERNAME, PASSWORD);
		   }
	   });
	   try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromMailAddr,fromName,"utf-8"));			
			msg.setRecipients(Message.RecipientType.TO,toMailAddr);
			msg.setSubject(title);
			msg.setSentDate(new Date());
			   
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "";
			htmlText += content;
			
			messageBodyPart.setContent(htmlText, "text/html;charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			Transport.send(msg);
		} catch (MessagingException mex) {
			System.out.println("send failed, exception: " + mex);
		}
		
	}
}
