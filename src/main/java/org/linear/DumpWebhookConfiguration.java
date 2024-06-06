package org.linear;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DumpWebhookConfiguration {

    @Bean
    public ObjectMapper initMapper(){
        return new ObjectMapper();
    }
}
