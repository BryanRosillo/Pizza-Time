package pizzas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testOrderController() throws Exception {
		mockMvc.perform(get("/orders/current").sessionAttr("pizzaOrder", new PizzaOrder()))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("pizzaOrder"))
			.andExpect(view().name("orderForm"))
			.andExpect(content().string(containsString("Order your pizza creations")));
	}
	

}
