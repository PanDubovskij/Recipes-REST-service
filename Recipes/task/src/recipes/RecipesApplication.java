package recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import recipes.config.RecipeConfig;

import java.util.Arrays;



@SpringBootApplication
public class RecipesApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
//        var context = new AnnotationConfigApplicationContext(RecipeConfig.class);
//        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
