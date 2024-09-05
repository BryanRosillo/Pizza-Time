package pizzas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderController {
	
	private OrderRepository orderRepo;
	
	@Autowired
	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid PizzaOrder pizzaOrder, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
		
		if(errors.hasErrors()) {
			return "orderForm";
		}
		
		pizzaOrder.setUser(user);
		
		orderRepo.save(pizzaOrder);
		
		sessionStatus.setComplete();
		return "redirect:/";
	}
	

}
