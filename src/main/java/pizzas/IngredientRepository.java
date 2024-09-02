package pizzas;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// If you want, you can change 'CrudRepository' for 'Repository' interface.
//CrudRepository and Repository can work with Spring Data JDBC, JPA, Cassandra.

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
	
	Iterable<Ingredient> findAll();
	
	Optional<Ingredient> findById(String id);
	
	Ingredient save(Ingredient ingredient);

}
