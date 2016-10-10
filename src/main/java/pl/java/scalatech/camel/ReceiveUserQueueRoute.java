package pl.java.scalatech.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class ReceiveUserQueueRoute extends RouteBuilder{
    private static final String ACTIVEMQ_USER = "activemq:user";
    @Override
    public void configure() throws Exception {
        from(ACTIVEMQ_USER).autoStartup(false).log(LoggingLevel.INFO, "${body}");
    }

}
