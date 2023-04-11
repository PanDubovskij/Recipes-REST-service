package recipes.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.model.RecipeDTO;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/recipe")
@AllArgsConstructor
public class RecipeController {

    private RecipeService recipeService;

    @PostMapping("new")
    public ResponseEntity<Map<String, Long>> saveRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        System.out.println("post response");
        System.out.println(recipeDTO);
        try {
            RecipeDTO dto = recipeService.saveRecipe(recipeDTO);
            System.out.println(dto);
            return new ResponseEntity<>(Map.of("id", dto.getId()), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable("id") Long id) {
        System.out.println("get response");
        try {
            RecipeDTO response = recipeService.getRecipeById(id);
            System.out.println(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") Long id) {
        System.out.println("delete response");
        try {
            recipeService.deleteRecipe(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
