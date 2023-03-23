package recipes.repository.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeList {

    private final List<Recipe> recipes;

    public RecipeList() {
        recipes = new ArrayList<>();
    }

    public boolean saveRecipe(Recipe recipe) {

//        boolean flag = recipes.add(recipe);
//        recipe.setId(recipes.indexOf(recipe));
//        return flag;
        return recipes.add(recipe);
    }


    public Recipe getRecipe(int id) throws IndexOutOfBoundsException {

        //compare index with size
        return recipes.get(id);

    }

    public void updateRecipe(int id, Recipe recipe) throws IndexOutOfBoundsException{

        //compare index with size
        recipes.set(id, recipe);
    }

    public boolean deleteRecipe(Recipe recipe) {
        return recipes.remove(recipe);
    }
}
