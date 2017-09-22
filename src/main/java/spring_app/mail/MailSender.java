package spring_app.mail;

import javax.mail.MessagingException;

public interface MailSender {

    void send(String toSend, String subject, String body) throws MessagingException;
}
