package za.co.sbsa.assesment.poke.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.sbsa.assesment.poke.api.model.Pokemon;
import za.co.sbsa.assesment.poke.api.service.PokeApiService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://104.45.174.205/"})
@RequestMapping(value = "/api/v2")
public class PokeApiRest {
    @Autowired
    PokeApiService pokeApiService;

    @GetMapping(value = "/pokemons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pokemon>> getPokemons() {
        return new ResponseEntity<>(pokeApiService.getPokemons(100), HttpStatus.OK);
    }

    @GetMapping(value = "/pokemon/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(pokeApiService.getPokemonById(id), HttpStatus.OK);
    }
}
