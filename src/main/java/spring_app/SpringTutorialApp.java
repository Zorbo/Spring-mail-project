package spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring_app.mail.MockMailSender;
import spring_app.mail.SmtpMailSender;


// @SpringBootApplication annotation will scan all the packages and classes for
// @Controller @Service @Repository @Configuration @SpringBootApplication
// IF you want to scan other packages you need to pass (scanBasePackageClasses)
@SpringBootApplication//(scanBasePackageClasses = {SmtpMailSender.class, MockMailSender.class})
public class SpringTutorialApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApp.class,args);
    }
}
