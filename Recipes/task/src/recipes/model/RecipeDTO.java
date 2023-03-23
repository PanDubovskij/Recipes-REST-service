package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {

    @JsonIgnore
    private int id;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}
