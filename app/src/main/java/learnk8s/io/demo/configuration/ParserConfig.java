package learnk8s.io.demo.configuration;

import org.commonmark.parser.Parser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserConfig {

    @Bean
    public Parser parser(){
        return Parser.builder().build();
    }
}
