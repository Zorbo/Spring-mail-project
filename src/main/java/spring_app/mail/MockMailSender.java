package spring_app.mail;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


// The @Component annotation create an instance of MockMailSender and
// store in a place called: APPLICATION CONTEXT
//@Component
// @Primary means that Spring use this as a PRIMARY BEAN istead of SmtpMailSender
//@Primary
public class MockMailSender implements MailSender {

    private static Log log = LogFactory.getLog(MockMailSender.class);

    @Override
    public void send(String toSend, String subject, String body) {

        log.info("Sending MOCK mail to: " + toSend);
        log.info("with subject: " + subject);
        log.info("and body: " + body);

    }
}
