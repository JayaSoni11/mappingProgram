//package com.demo.mapping.mail;
//
//import java.util.Properties;
//
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.internet.MimeMessage;
//
//public class MailAlert {
//	
//	String to="sonijjaya@gmail.com";
//	String from="sonijjaya@gmail.com";		
//	String host="smtp.gmail.com";
//	
//	Properties props=System.getProperties();
//	props.put("mail.smtp.host",host);
//	props.put("mail.smtp.port", "465");
//	props.put("mail.smtp.starttls.enable", "true");
//	props.put("mail.smtp.auth", "true");
//
//    Session session=Session.getInstance(props, new javax.mail.Authenticator() {
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication("sonijjaya@gmail.com", "cffuxbzybwfpltwt");
//    }
//    });
//    try {
//        MimeMessage message = new MimeMessage(session);
//        message.setFrom(new InternetAddress("sonijjaya@gmail.com"));
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress.parse(toEmail, false));
//        message.setSubject("This is the email subject");
//        message.setHeader("Hi, everyone");  
//        message.setText("This is the email body");
//
//        Transport.send(message);
//      } catch (MessagingException mex) {
//        mex.printStackTrace();
//      }
//   }
//}
