package pomelo.cas.client.core;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.unicon.cas.client.configuration.EnableCasClient;

@SpringBootApplication
@EnableCasClient
@Controller
@RequestMapping("/cas-client")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/{username}")
	public ResponseEntity<?> info(@PathVariable String username) {
		return new ResponseEntity<>(username, HttpStatus.OK);
	}

	@RequestMapping("/logout")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "redirect:http://localhost:8080/cas/logout";
	}
}
