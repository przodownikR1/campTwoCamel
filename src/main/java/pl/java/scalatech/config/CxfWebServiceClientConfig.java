package pl.java.scalatech.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.java.scalatech.camel.CurrentService;

@Configuration
public class CxfWebServiceClientConfig {
	private static final String HTTP_LOCALHOST_5555_SOAP_BY_CODE = "http://localhost:5555/soap/byCode";
    @Bean
	public JaxWsProxyFactoryBean jaxWsProxyFactoryBean() {
        JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
        jaxWsProxyFactory.setServiceClass(CurrentService.class);
        jaxWsProxyFactory.setAddress(HTTP_LOCALHOST_5555_SOAP_BY_CODE);
        return jaxWsProxyFactory;
    }
	@Bean(name="client")
	public CurrentService currencyWsClient() {
		return (CurrentService)jaxWsProxyFactoryBean().create();
	}

}