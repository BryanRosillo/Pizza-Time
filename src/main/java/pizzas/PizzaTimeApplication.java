package pizzas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pizzas.Ingredient.Type;

@SpringBootApplication
public class PizzaTimeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaTimeApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
	    return args -> {
	        repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
	        repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
	        repo.save(new Ingredient("MSHR", "Mushroom", Type.VEGGIES));
	        repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
	        repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
	        repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
	        repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
	        repo.save(new Ingredient("SUCR", "Sour Cream", Type.SAUCE));
	    };
	}
	

}
