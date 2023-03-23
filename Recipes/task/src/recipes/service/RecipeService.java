package recipes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import recipes.mapper.RecipeMapper;
import recipes.model.RecipeDTO;
import recipes.repository.entity.RecipeList;


@Component
@AllArgsConstructor
public class RecipeService {

    private static int id;

    private final RecipeList recipes;

    private final RecipeMapper recipeMapper;


    public boolean saveRecipe(RecipeDTO dto) {

        System.out.println(id);

        dto.setId(id);
        id++;
        return recipes.saveRecipe(recipeMapper.convertDTO2Recipe(dto));
    }


    public RecipeDTO getRecipe(int id) throws IndexOutOfBoundsException {

        //compare index with size
        return recipeMapper.convertRecipe2DTO(recipes.getRecipe(id));

    }

//    public void updateRecipe(int id, RecipeDTO dto) throws IndexOutOfBoundsException{
//
//        //compare index with size
//
//        recipes.updateRecipe(id, recipeMapper.convertDTO2Recipe(dto));
//    }

//    public boolean deleteRecipe(RecipeDTO dto) {
//        id--;
//        return recipes.deleteRecipe(recipeMapper.convertDTO2Recipe(dto));
//    }
}
