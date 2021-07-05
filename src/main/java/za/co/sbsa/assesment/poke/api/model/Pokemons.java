package za.co.sbsa.assesment.poke.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemons {
    private Integer count;
    private String next;
    private String previous;
    private List<Result> results;
}
