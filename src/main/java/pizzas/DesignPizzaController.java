package pizzas;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import pizzas.Ingredient.Type;

@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("MSHR", "Mushroom", Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CHED", "Cheddar", Type.CHESSE),
				new Ingredient("JACK", "Monterrey Jack", Type.CHESSE),
				new Ingredient("SLSA", "Salsa", Type.SAUCE),
				new Ingredient("SUCR", "Sour Cream", Type.SAUCE)
				);
		
		Type[] types = Ingredient.Type.values();
		for(Type type: types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients,type)
					);
		}
		
	}
	
	@ModelAttribute(name="pizzaOrder")
	public PizzaOrder order() {
		return new PizzaOrder();
	}
	
	@ModelAttribute(name="pizza")
	public Pizza pizza() {
		return new Pizza();
	}
	
	@GetMapping
	public String showDesingForm(){
		return "design";
	}
	
	
	@PostMapping
	public String processPizza(@Valid Pizza pizza, Errors errors, @ModelAttribute PizzaOrder pizzaOrder) {
		
		if(errors.hasErrors()) {
			return "design";
		}
		
		pizzaOrder.addPizza(pizza);
		return "redirect:/orders/current";
	}
	

	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(
					x-> x.getType().equals(type)
				)
				.collect(Collectors.toList());
	}
}
