package action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPSendFailedException;


 
public class SendMail {
 
	public boolean sendEmail(String email, String checkNum) {
         
        Properties p = System.getProperties();
        boolean idensuccess = false;
        
        p.put("mail.smtp.host", "smtp.naver.com");
        p.put("mail.smtp.auth","true");                 
        p.put("mail.smtp.port", "587");                 
        p.put("mail.smtp.starttls.enable", "true");     
        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
        p.put("mail.smtp.debug", "true");
        Authenticator auth = new Au();
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
         
        try{
           
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress("testmail1861@naver.com"); 
          
            msg.setFrom(from);
            InternetAddress to = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, to);
            
            msg.setSubject("인증번호 제일 싫어요", "UTF-8");
           
            msg.setText("인증번호 : " + checkNum, "UTF-8");
            
            msg.setHeader("content-Type", "text/html");
            
            javax.mail.Transport.send(msg, msg.getAllRecipients());
            idensuccess = true;
            

             
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
            idensuccess= false;
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
            idensuccess= false;
            
        }
        catch (Exception msg_e) {
            msg_e.printStackTrace();
            idensuccess= false;

        }
        
        return idensuccess;
    }

	public boolean sendEmail(String email, String equalnumber, String ranPw) {
		// TODO Auto-generated method stub
		Properties p = System.getProperties();
        boolean idensuccess = false;
        
        
       
        
        p.put("mail.smtp.host", "smtp.naver.com");
        p.put("mail.smtp.auth","true");                 
        p.put("mail.smtp.port", "587");                 
        p.put("mail.smtp.starttls.enable", "true");     
        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
        p.put("mail.smtp.debug", "true");
        Authenticator auth = new Au();
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
         
        try{
           
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress("testmail1861@naver.com"); 
          
            msg.setFrom(from);
            InternetAddress to = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, to);
            
            msg.setSubject("인증번호 제일 싫어요", "UTF-8");
           
            msg.setText("인증번호 : " + ranPw, "UTF-8");
            
            msg.setHeader("content-Type", "text/html");
            
            javax.mail.Transport.send(msg, msg.getAllRecipients());
            idensuccess = true;
            

             
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
            idensuccess= false;
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
            idensuccess= false;
            
        }
        catch (Exception msg_e) {
            msg_e.printStackTrace();
            idensuccess= false;

        }
        
        return idensuccess;
	}

	public boolean sendHospReqEmail(String id, String email, String nickname) {
		// TODO Auto-generated method stub
		 
        Properties p = System.getProperties();
        boolean idensuccess = false;
        
        p.put("mail.smtp.host", "smtp.naver.com");
        p.put("mail.smtp.auth","true");                 
        p.put("mail.smtp.port", "587");                 
        p.put("mail.smtp.starttls.enable", "true");     
        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
        p.put("mail.smtp.debug", "true");
        Authenticator auth = new Au();
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
         
        try{
           
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress("testmail1861@naver.com"); 
          
            msg.setFrom(from);
            InternetAddress to = new InternetAddress("testmail1861@naver.com");
            msg.setRecipient(Message.RecipientType.TO, to);
            
            msg.setSubject("병원관리자요청 " + nickname, "UTF-8");
           
            msg.setText("병원 관리자 권한을 요청합니다. id : " + id + " email : " + email + " nickname : " + nickname , "UTF-8");
            
            msg.setHeader("content-Type", "text/html");
            
            javax.mail.Transport.send(msg, msg.getAllRecipients());
            idensuccess = true;
            

             
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
            idensuccess= false;
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
            idensuccess= false;
            
        }
        catch (Exception msg_e) {
            msg_e.printStackTrace();
            idensuccess= false;

        }
        
        return idensuccess;
	}
}

class Au extends Authenticator {
    
    private PasswordAuthentication pa;
    public Au(){
         
        String id = "testmail1861@naver.com";  
        String pw = "adpcatiet6)L82j*";       
 
       
        pa = new PasswordAuthentication(id, pw);
    }
 
   
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
} 
 
