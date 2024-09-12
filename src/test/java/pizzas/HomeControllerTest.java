package pizzas;

import static org.hamcrest.CoreMatchers.containsString;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import pizzas.models.IngredientRepository;
import pizzas.models.OrderRepository;
import pizzas.models.PizzaRepository;
import pizzas.models.UserRepository;

@WebMvcTest()
public class HomeControllerTest {
	
	@MockBean
	private IngredientRepository ingredientRepository;
	
	@MockBean
	private OrderRepository orderRepository;
	
	@MockBean
	private UserRepository userRepository;
	
	
	@MockBean
	private PizzaRepository pizzaRepository;

	@MockBean
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@WithMockUser(username = "user", roles = {"USER"})
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("home"))
			.andExpect(content().string(containsString("It's time for pizza :D")));
		
	}

}
