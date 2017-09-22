package spring_app.mail;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

// We can give another name to the beam @Component("HERE")
//@Component("newName")

public class SmtpMailSender implements MailSender {

    private static Log log = LogFactory.getLog(SmtpMailSender.class);

    private JavaMailSender javaMailSender;

    public SmtpMailSender(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String toSend, String subject, String body) throws MessagingException {
        /*
        log.info("Sending SMTP mail to: " + toSend);
        log.info("with subject: " + subject);
        log.info("and body: " + body);
        */

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message,true); // true indicates, multipart message

        helper.setSubject(subject);
        helper.setTo(toSend);
        helper.setText(body, true); // true indicates html

        // continue using helper for more functionalities like adding attachments, etc.

        javaMailSender.send(message);

    }
}
