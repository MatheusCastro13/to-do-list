package matheus.to_do_list.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

	@GetMapping
	public String redirect() {
		return "redirect:/tasks";
	}
}
