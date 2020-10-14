package com.sankalpsingh.otp.admin;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailClient {
	
	void sendOTP(String email, String otp) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session mailsession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sankalpsingh606@gmail.com","Sankalp@1997");
			}
		});

		try {
					
			MimeMessage message = new MimeMessage(mailsession);
			//message.setFrom( new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("otp");
			message.setText("Your OTP : " + otp);
			// send message
			Transport.send(message);
			}catch(MessagingException mex){
				mex.printStackTrace();
			}
		
	}
}
