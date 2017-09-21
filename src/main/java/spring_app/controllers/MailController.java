package spring_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_app.mail.MailSender;
import spring_app.mail.MockMailSender;

// In Dependency injection Spring will find this controller because the
// @RestController annotation
// Oder is: @Component --> @RestController --> @Autowired
@RestController
public class MailController {


    // This composition is not good we can use dependency injection instead
    // To solve this use @Component annotation in MockMailSender class
    // Delete the "= new MockMailSender();" AND USE @Autowired annotation in here
    // this is one way of dependency injection in Spring

    //@Autowired
    private MailSender mailSender; //= new MockMailSender();


    // Here @Autowired inject the MockMailSender in this method parameter
    // This will also works on Constructors to in EXPLICIT WAY SO WE DONT NEED THE AUTOWIRED ANOTATION
    // @Autowired
    //@Qualifier here call the MailConfig smtpMailSender method, ITS CASE SENSITIVE
    public MailController( MailSender smtp) {
        this.mailSender = smtp;
    }

    @RequestMapping("/mail")  // This means https://localhost:8080/hello
    public String  mail(){

        mailSender.send("mail@example.com","Test mail sending","I just made a mail sender");
        return "Mail sent!";
    }
}
