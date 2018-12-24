package pl.eoller.cryptonit.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class AppConf {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

}
