package za.co.sbsa.assesment.poke.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import za.co.sbsa.assesment.poke.api.client.PokeApiWebClient;
import za.co.sbsa.assesment.poke.api.model.Pokemon;
import za.co.sbsa.assesment.poke.api.model.Pokemons;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = "pokemons")
@Service
@Slf4j
public class PokeApiServiceImpl implements PokeApiService {

    @Autowired
    PokeApiWebClient pokeApiWebClient;

    @Value("${poke.api.base.url}")
    String baseUrl;

    /**
     * getPokemons method
     *
     * @param numberOfPokemons maximum number
     * @return Pokemons object
     */
    @Cacheable(value = "pokemonscache")
    @Override
    public List<Pokemon> getPokemons(Integer numberOfPokemons) {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 1; i <= numberOfPokemons + 2; i++) {
            if (i == 35) i++;
            if (i == 80) i++;
            Pokemon pokemon = getPokemonById(i);
            log.debug("Pokemon: {}", pokemon.toString());
            if (pokemon != null) {
                pokemonList.add(pokemon);
            }
            pokemon = null;
        }
        return pokemonList;
    }

    /**
     * getPokemonById method
     *
     * @param id pokemon id
     * @return Pokemon object
     */
    @Cacheable(value = "pokemoncache")
    @Override
    public Pokemon getPokemonById(Integer id) {
        return pokeApiWebClient.getWebClient()
                .build()
                .get()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .bodyToMono(Pokemon.class)
                .block();
    }
}
