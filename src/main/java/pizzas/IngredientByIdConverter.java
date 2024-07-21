package pizzas;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pizzas.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	
	private Map<String, Ingredient> ingredientMap = new HashMap<>();
	
	public IngredientByIdConverter() {
		ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		ingredientMap.put("MSHR", new Ingredient("MSHR", "Mushroom", Type.VEGGIES));
		ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHESSE));
		ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.CHESSE));
		ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
		ingredientMap.put("SUCR", new Ingredient("SUCR", "Sour Cream", Type.SAUCE));
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientMap.get(id);
	}
	
}
