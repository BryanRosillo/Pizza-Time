package pizzas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Ingredient {
	
	@Id
	private final String id;
	private final String name;
	
	@Enumerated(EnumType.STRING)
	private final Type type;
	

	public enum Type{
		PROTEIN, VEGGIES, CHEESE, SAUCE
	}

}
