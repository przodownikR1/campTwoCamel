package pl.java.scalatech.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {
    @Bean
    ActiveMQConnectionFactory amqFactory(){
        return new ActiveMQConnectionFactory("tcp://localhost:61616"); 
    }
   
   
}
