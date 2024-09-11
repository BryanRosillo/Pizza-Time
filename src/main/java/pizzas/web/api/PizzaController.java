package pizzas.web.api;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pizzas.models.Pizza;
import pizzas.models.PizzaRepository;

@RestController
@RequestMapping(path="/api/pizzas", produces="application/json")
@CrossOrigin(origins="http://pizza-time:8080")
public class PizzaController {
	
	private PizzaRepository pizzaRepo;
	
	public PizzaController(PizzaRepository pizzaRepo) {
		this.pizzaRepo = pizzaRepo;
	}
	
	@GetMapping(params="recent")
	public Iterable<Pizza> recentPizzas(){
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return pizzaRepo.findAll(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pizza> pizzaById(@PathVariable("id") Long id){
		Optional<Pizza> pizza = pizzaRepo.findById(id);
		if(pizza.isPresent()) {
			return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Pizza postPizza(@RequestBody Pizza pizza) {
		return pizzaRepo.save(pizza);
	}
	
	
	

}
