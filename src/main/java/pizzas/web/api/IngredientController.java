package pizzas.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pizzas.models.Ingredient;
import pizzas.models.IngredientRepository;

@RestController()
@RequestMapping(path="/api/ingredients", produces="application/json" )
@CrossOrigin(origins="http://localhost:8080")
public class IngredientController {
	
	private IngredientRepository ingredientRepo;

	@Autowired
	public IngredientController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping
	public Iterable<Ingredient> allIngredients(){
		return this.ingredientRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
		return this.ingredientRepo.save(ingredient);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteIngredient(@PathVariable("id") String id) {
		this.ingredientRepo.deleteById(id);
	}
	
	
	
	

}
