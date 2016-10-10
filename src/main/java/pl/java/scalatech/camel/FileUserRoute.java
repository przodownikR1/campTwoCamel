package pl.java.scalatech.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.stereotype.Component;

import pl.java.scalatech.domain.User;

@Component
public class FileUserRoute extends RouteBuilder{ //split and compute salary by actual exchange rate
    private static final String FILE_USER_FILE = "file:///home/przodownik/user?fileName=1.csv&move=backup";
    
    BindyCsvDataFormat bindy = new BindyCsvDataFormat(User.class);
    @Override
    public void configure() throws Exception {
        from(FILE_USER_FILE).autoStartup(false)
        .split(body().tokenize("\n"))
        .streaming()
        .log(LoggingLevel.INFO, "camel", "body is ${body}")
        .unmarshal(bindy);
   
        }
       

}
