package za.co.sbsa.assesment.poke.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {
    private Ability ability;
    private Boolean is_hidden;
    private Integer slot;
}
