package za.co.sbsa.assesment.poke.api.service;

import za.co.sbsa.assesment.poke.api.model.Pokemon;
import za.co.sbsa.assesment.poke.api.model.Pokemons;

import java.util.List;

public interface PokeApiService {
    /**
     * getPokemons method
     * @param numberOfPokemons maximum number
     * @return Pokemons object
     */
    List<Pokemon> getPokemons(final Integer numberOfPokemons);

    /**
     * getPokemonById method
     * @param id pokemon id
     * @return Pokemon object
     */
    Pokemon getPokemonById(final Integer id);
}
