package spring_app.mail;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// If you need to use a class as a BEAN and you dont have annotations for that class
// you can reach that for SpringBoot creating a "Config" class
@Configuration
// You can also use XML files to config beans
public class MailConfig {

    // We told Spring by this annotations that these classes are BEANS, use these classes as BEANS
    // By using this methods!!

    @Bean
    // Profile will config only in dev enviroment
    // We set this in the properties file!!!
    @Profile("dev")
    public MailSender mockMailSender(){

        return new MockMailSender();
    }

    @Bean
    // You can use Profile on the whole class!!!!
    @Profile("!dev")
    public MailSender smtpMailSender(){

        return new SmtpMailSender();
    }

}
