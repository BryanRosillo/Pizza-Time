package pizzas.models;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaRepository extends PagingAndSortingRepository<Pizza,Long>{
	
	Optional<Pizza> findById(Long id);
	
	Pizza save(Pizza pizza);

}
