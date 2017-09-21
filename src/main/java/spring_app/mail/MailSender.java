package spring_app.mail;

public interface MailSender {

    void send(String toSend, String subject, String body);
}
