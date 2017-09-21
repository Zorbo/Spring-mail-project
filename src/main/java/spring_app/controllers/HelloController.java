package spring_app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    // Here we read the properties file app.name VALUE and save it to a String(appName)
    @Value("${app.name}")
    private String appName;


    @RequestMapping("/hello")  // This means https://localhost:8080/hello
    public String  hello(){
        return "Hello World! " + appName;
    }
}
