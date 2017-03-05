package cn.takeout.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
	
	private static Session initMail() throws AddressException, MessagingException {
	// 1.创建一个程序与邮件服务器会话对象Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP"); //发送协议
		props.setProperty("mail.host", "smtp.163.com"); //发送的服务器
		props.setProperty("mail.smtp.auth", "true"); //指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javawebtestsimmon", "xsw123"); // 用户名密码
			}
		};

		Session session = Session.getInstance(props, auth);
		return session;
	}
	
	public static void sendMail(String to, String code)
			throws AddressException, MessagingException {
		
		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(initMail());

		message.setFrom(new InternetAddress("javawebtestsimmon@163.com")); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(to)); // 设置发送方式与接收者

		message.setSubject("来自Takeout激活邮件");

		message.setContent("<h1>来自Takeout的官网激活邮件</h1><h3><a href='http://10.103.14.81:8080/Takeout/customer_active.action?code="+code+"'>http://10.103.14.81:8080/Takeout/customer_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8"); 
		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
	
	public static void sendPwdMail(String to) throws AddressException, MessagingException {
		initMail();
		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(initMail());

		message.setFrom(new InternetAddress("javawebtestsimmon@163.com")); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(to)); // 设置发送方式与接收者

		message.setSubject("来自Takeout密码找回邮件");
		
		message.setContent("<h1>点击链接重置密码</h1><h3><a href='http://10.103.14.81:8080/Takeout/customer_updatePwdPage.action?email="+to+"'>http://10.103.14.81:8080/Takeout/customer_updatePwd.action?email="+to+"</a></h3>", "text/html;charset=UTF-8"); 
		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
	
}
