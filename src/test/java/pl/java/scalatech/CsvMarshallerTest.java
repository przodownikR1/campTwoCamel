package pl.java.scalatech;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;

@Slf4j
@Ignore
public class CsvMarshallerTest {
    protected CamelContext camelContext;

    @Test
    public void shouldCreateCSVFile() throws Exception {
        ModelCamelContext context = new DefaultCamelContext();
        context.addRoutes(new CsvRoute());
        this.camelContext = context;
        context.start();
        Thread.sleep(2000);
        context.stop();
    }

    class CsvRoute extends RouteBuilder {
        BindyCsvDataFormat bindy = new BindyCsvDataFormat(Person.class);

        @Override
        public void configure() throws Exception {

            from("file:///home/przodownik/user?noop=true&fileName=custs.csv")
            .split(body().tokenize("\n"))
            .streaming()
             .log(LoggingLevel.INFO, "camel", "body is ${body}")
             .unmarshal(bindy)
             .log(LoggingLevel.INFO, "camel", "Result unmarshal : ${body}");

        }
    };

}