package spring_app.mail;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// We can give another name to the beam @Component("HERE")
//@Component

public class SmtpMailSender implements MailSender {

    private static Log log = LogFactory.getLog(SmtpMailSender.class);

    @Override
    public void send(String toSend, String subject, String body) {

        log.info("Sending SMTP mail to: " + toSend);
        log.info("with subject: " + subject);
        log.info("and body: " + body);

    }
}
