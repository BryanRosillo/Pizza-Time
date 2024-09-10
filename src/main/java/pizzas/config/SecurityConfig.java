package pizzas.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pizzas.models.User;
import pizzas.models.UserRepository;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username);
			if(user !=null) {
				return user;
			}else {
				throw new UsernameNotFoundException("User " + username + " not found");
			}
		
		};
	}
	
	
	/*IMPORTANT: ONLY FOR DEVELOPMENT THE CSRF TOKEN IS DISABLED.*/
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authz -> authz
				.requestMatchers("/design","/orders").hasRole("USER")
				.requestMatchers(PathRequest.toH2Console()).permitAll()
				.anyRequest().permitAll())
		.formLogin(formLogin->formLogin
				.loginPage("/login")
				.defaultSuccessUrl("/home")
				)
		.logout(logout -> logout
				.logoutSuccessUrl("/").permitAll())
		.csrf(csrf -> csrf
				.disable())
		.headers(headers -> headers
				.frameOptions(origin -> origin
						.sameOrigin()));
		
		return http.build();
		
	}
	

}
