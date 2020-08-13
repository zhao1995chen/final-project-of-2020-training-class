package com.game.spring.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil implements Runnable {
	private String email;
	private String code;

	public MailUtil(String email, String code) {
		this.email = email;
		this.code = code;
	}

	public void run() {

		String from = "123@gmail.com";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");

		try {

			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);

			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("123@gmail.com", "123");
				}
			});

			// 2.创建邮件对象
			Message message = new MimeMessage(session);
			// 2.1设置发件人
			message.setFrom(new InternetAddress(from));
			// 2.2设置接收人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			// 2.3设置邮件主题
			message.setSubject("帳號激活");
			// 2.4设置邮件内容
			String content = "<html><head></head><body><h1>這是一封激活郵件,激活請點擊以下鏈接</h1><h3><a href='http://localhost/mapGame/ActiveServlet?code="
					+ code + "'>http://localhost/mapGame/ActiveServlet?code=" + code
					+ "</href></h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 3.发送邮件
			Transport.send(message);
			System.out.println("郵件成功發送!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
