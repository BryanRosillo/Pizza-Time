package pizzas;

import lombok.Data;

@Data
public class Ingredient {
	private final String id;
	private final String name;
	private final Type type;
	
	
	
	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}



	public enum Type{
		PROTEIN, VEGGIES, CHESSE, SAUCE
	}
	
    public Type getType() {
        return type;
    }


}
