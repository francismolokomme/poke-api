package za.co.sbsa.assesment.poke.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private Integer id;
    private Integer height;
    private Integer weight;
    private String name;
    private Integer base_experience;
    private List<Abilities> abilities;
    private Sprites sprites;
}
