package recipes.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.model.RecipeDTO;
import recipes.service.RecipeService;

@RestController
@RequestMapping("api/recipe")
@AllArgsConstructor
public class RecipeController {

    private RecipeService recipeService;

    private ObjectMapper objectMapper;


    @PostMapping("/new")
    public ResponseEntity<String> addRecipe(@RequestBody String recipeJSON) {
        System.out.println("post response");
        System.out.println(recipeJSON);
        String response;
        try {
            RecipeDTO dto = objectMapper.readValue(recipeJSON, RecipeDTO.class);
            recipeService.saveRecipe(dto);
            System.out.println("\n" + dto.getId() + "\n");

            response = "{\n\t\"id\": " + dto.getId() + "\n}";
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            response = "Wrong JSON!";
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getRecipe(@PathVariable("id") int id) {
        System.out.println("get response");
        String response;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipeService.getRecipe(id));
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IndexOutOfBoundsException | JsonProcessingException e) {
            response = "No such content";
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
