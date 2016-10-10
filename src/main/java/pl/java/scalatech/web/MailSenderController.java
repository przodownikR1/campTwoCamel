package pl.java.scalatech.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {
    @Autowired
    private ProducerTemplate producer;
    
    @GetMapping("/send")
    String sendMail(){
        
        Map<String,Object> msg= new HashMap<>();
        msg.put("firstName", "Claus");
        msg.put("lastName", "Ibsen");
        msg.put("item", "Camel in Action");
        producer.sendBodyAndHeaders("direct:start", "Hello World",msg);
        return "ok";
        
    }
    
}
