package pizzas;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<PizzaOrder, String> {
	
	PizzaOrder save(PizzaOrder order);

}
