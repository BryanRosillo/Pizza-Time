package pizzas;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

// If you want, you can change 'CrudRepository' for 'Repository' interface.
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
	
	Iterable<Ingredient> findAll();
	
	Optional<Ingredient> findById(String id);
	
	Ingredient save(Ingredient ingredient);

}
