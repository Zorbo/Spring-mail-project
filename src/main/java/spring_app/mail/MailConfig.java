package spring_app.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

// If you need to use a class as a BEAN and you dont have annotations for that class
// you can reach that for SpringBoot, creating a "Config" class
@Configuration
// You can also use XML files to config beans
public class MailConfig {

    // We can do this automaticly if we pass these as parameters in smtpMailSender method
   // @Autowired
   // private JavaMailSender javaMailSender;

    // We told Spring by this annotations that these classes are BEANS, use these classes as BEANS
    // By using this methods!!

    @Bean
    // Profile will config only in dev profile/enviroment/etc...
    // We set this in the properties file!!!
    // @Profile("dev")
    @ConditionalOnProperty
            //if properties file dont have the spring.mail.host then itt will use MOCK mail
            // this is the way to negate the @ConditionalOnProperty
            (name = "spring.mail.host", havingValue = "foo", matchIfMissing = true)
    public MailSender mockMailSender(){

        return new MockMailSender();
    }

    @Bean
    // You can use Profile on the whole class!!!!
    // We can use negate ! here to set false
    //  @Profile("!dev")
    @ConditionalOnProperty("spring.mail.host")
    // We pass here the JavaMailSender in the parameters
    public MailSender smtpMailSender(JavaMailSender javaMailSender){

        demoBean();
        return new SmtpMailSender(javaMailSender);
    }

    // Inject DemoBean by using this method in smtpMailSender
    @Bean
    public DemoBean demoBean(){

        return new DemoBean();
    }

}
