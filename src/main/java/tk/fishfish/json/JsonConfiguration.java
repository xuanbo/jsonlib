package tk.fishfish.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * json configuration
 *
 * @author 奔波儿灞
 * @version 1.0.0
 */
@Configuration
@AutoConfigureAfter(JacksonAutoConfiguration.class)
public class JsonConfiguration {

    @Bean
    public Json json(ObjectMapper objectMapper) {
        return new JacksonJson(objectMapper);
    }

    @Bean
    public JsonPath jsonPath(ObjectMapper objectMapper) {
        return new JacksonJsonPath(objectMapper);
    }

    @Bean
    public JsonExtractor jsonExtractor(Json json, JsonPath jsonPath) {
        return new GroovyJsonExtractor(json, jsonPath);
    }

}
