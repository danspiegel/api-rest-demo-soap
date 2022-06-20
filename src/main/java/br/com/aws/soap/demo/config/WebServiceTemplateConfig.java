package br.com.aws.soap.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class WebServiceTemplateConfig {

    @Autowired
    private WSProperties wsProperties;

    @Bean
    public WebServiceTemplate webServiceTemplateBroker() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        ClientInterceptor[] interceptors = { new SOAPInterceptor(), wss4jSecurityInterceptor() };
        webServiceTemplate.setInterceptors(interceptors);
        marshaller.setPackagesToScan("org.tempuri");
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        return webServiceTemplate;
    }

    private Wss4jSecurityInterceptor wss4jSecurityInterceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setSecurementPasswordType("PasswordText");
        securityInterceptor.setSecurementUsername("admin");
        securityInterceptor.setSecurementPassword("123");
        return securityInterceptor;
    }

}
