package pl.java.scalatech.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.idempotent.MemoryIdempotentRepository;
import org.springframework.stereotype.Component;
@Component
public class  MailRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:start").to("velocity:mail.vm").to("file://mail/filename=raport.txt").to("mock:343");
        
        
       
        
    }

}
