package ua.rd.web.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ua.rd.JavaBasedRepoConfig;
import ua.rd.JavaBasedServiceConfig;
import ua.rd.services.TweetService;

@Configuration
@Import({JavaBasedServiceConfig.class, JavaBasedRepoConfig.class})
public class WebInfConfig {

    @Bean
    public HandlerMapping handlerMapping() {
        return new BeanNameURLHandlerMapping();
    }

    @Bean
    public MyController hello() {
        return new HelloContoller();
    }

    @Bean
    public MyController tweets(TweetService tweetService) {
        return new TweetController(tweetService);
    }


}
