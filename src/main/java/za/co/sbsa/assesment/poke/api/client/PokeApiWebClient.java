package za.co.sbsa.assesment.poke.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PokeApiWebClient {
    @Bean
    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }
}
