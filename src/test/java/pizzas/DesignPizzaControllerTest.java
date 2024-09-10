package pizzas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import pizzas.controllers.DesignPizzaController;
import pizzas.models.IngredientRepository;
import pizzas.models.OrderRepository;
import pizzas.models.UserRepository;

@WebMvcTest(DesignPizzaController.class)
public class DesignPizzaControllerTest {
	
	@MockBean
	private IngredientRepository ingredientRepository;
	
	@MockBean
	private OrderRepository orderRepository;
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MockMvc mockMvc;
	

	
	@Test
	@WithMockUser(username = "user", roles = {"USER"})
	public void testDesignPizzaController() throws Exception {
		mockMvc.perform(get("/design"))
		.andExpect(status().isOk())
		.andExpect(view().name("design"))
		.andExpect(content().string(containsString("Design your Pizza")));	
		
	}
	

}
