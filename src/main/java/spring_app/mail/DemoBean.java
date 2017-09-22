package spring_app.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DemoBean {

    private static Log log = LogFactory.getLog(SmtpMailSender.class);

    public DemoBean() {

        log.info("Demo bean created");
    }
}
