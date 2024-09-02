package pizzas;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<PizzaOrder, UUID> {
	
	PizzaOrder save(PizzaOrder order);

}
