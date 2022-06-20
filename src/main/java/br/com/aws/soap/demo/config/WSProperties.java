package br.com.aws.soap.demo.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "demo.ws")
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WSProperties {

    private String serviceUrl;

}
