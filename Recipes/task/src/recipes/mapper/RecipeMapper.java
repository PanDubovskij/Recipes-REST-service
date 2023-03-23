package recipes.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import recipes.model.RecipeDTO;
import recipes.repository.entity.Recipe;

@Component
@AllArgsConstructor
public class RecipeMapper {

    private final ModelMapper modelMapper;

    private final ObjectMapper objectMapper;

    public RecipeDTO convertRecipe2DTO(Recipe recipe) {
        return modelMapper.map(recipe, RecipeDTO.class);
    }

    public Recipe convertDTO2Recipe(RecipeDTO dto) {
        return modelMapper.map(dto, Recipe.class);
    }


    public RecipeDTO convertJSON2DTO(String recipe) throws JsonProcessingException {
        return objectMapper.readValue(recipe, RecipeDTO.class);
    }

    public String convertDTO2JSON(RecipeDTO dto) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
    }
}
