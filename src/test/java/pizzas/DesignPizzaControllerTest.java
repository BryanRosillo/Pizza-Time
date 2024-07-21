package pizzas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DesignPizzaController.class)
public class DesignPizzaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testDesignPizzaController() throws Exception {
		mockMvc.perform(get("/design"))
		.andExpect(status().isOk())
		.andExpect(view().name("design"))
		.andExpect(content().string(containsString("Design your Pizza")));	
		
	}
	

}
