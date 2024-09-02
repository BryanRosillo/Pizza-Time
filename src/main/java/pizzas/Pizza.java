package pizzas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table("pizzas")
public class Pizza{
	
	@PrimaryKeyColumn(type=PrimaryKeyType.PARTITIONED)
	private UUID id = Uuids.timeBased();
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long.")
	private String name;
	
	@PrimaryKeyColumn(type=PrimaryKeyType.CLUSTERED, ordering=Ordering.DESCENDING)
	private Date createdAt = new Date();
	
	@Size(min=1, message="You must choose at least 1 ingredient.")
	@Column("ingredients")
	private List<IngredientUDT> ingredients = new ArrayList<>();
	
	public void addIngredient(IngredientUDT ingredient) {
		this.ingredients.add(ingredient);
	}
	
}
