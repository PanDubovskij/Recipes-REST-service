package recipes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.mapper.RecipeMapper;
import recipes.model.RecipeDTO;
import recipes.repository.RecipeRepository;
import recipes.repository.entity.Recipe;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeMapper recipeMapper;

    private final RecipeRepository repository;

    public RecipeDTO getRecipeById(Long id) throws NoSuchElementException {
        Optional<Recipe> recipe = repository.findById(id);
        if (recipe.isPresent()) {
            System.out.println(recipe);
            return recipeMapper.convertRecipe2DTO(recipe.get());
        } else {
            ///////////////////////////////////////////
            throw new NoSuchElementException();
            //////////////////////////////////////////
        }
    }

    public RecipeDTO saveRecipe(RecipeDTO recipeDTO) throws IllegalArgumentException {
        //////////////////////////////////////////////////
        System.out.println("///////////////////////////////////");
        System.out.println("///////////////////////////////////");
        System.out.println("///////////////////////////////////");


        Recipe recipe = recipeMapper.convertDTO2Recipe(recipeDTO);
        System.out.println(recipe);

        Recipe savedRecipe = repository.save(recipe);
        System.out.println(savedRecipe);

        RecipeDTO returnValue = recipeMapper.convertRecipe2DTO(savedRecipe);
        System.out.println(returnValue);


        System.out.println("///////////////////////////////////");
        System.out.println("///////////////////////////////////");
        System.out.println("///////////////////////////////////");


        return returnValue;
    }


    public void deleteRecipe(Long id) throws NoSuchElementException {
        /////////////////////////////////////////
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
        //////////////////////////////////////
    }
}
