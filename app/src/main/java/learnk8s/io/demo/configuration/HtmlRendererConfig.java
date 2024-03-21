package learnk8s.io.demo.configuration;

import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HtmlRendererConfig {

    @Bean
    public HtmlRenderer htmlRenderer(){
        return HtmlRenderer.builder().build();
    }
}
