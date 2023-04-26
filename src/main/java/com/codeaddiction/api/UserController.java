package com.codeaddiction.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeaddiction.model.UserRequest;
import com.codeaddiction.service.UserService;

@RestController
@RequestMapping("/india")
public class UserController {
	
	
	private UserService userService;
	
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/add-user")
	public String addNewUser(@RequestBody UserRequest userRequest) {
	
		return userService.addNewUser(userRequest);
	}
	
	@GetMapping("/public")
	public String helloUser() {
       return "Hello NORMAL User kaise Ho App?..!!";
	}
	
	
	@GetMapping("/admin")
	public String helloadmin() {
		return "Hello ADMIN..!!";
	}
	
	@GetMapping("/common")
	public String helloCommon() {
		return "Hello common..!!";
	}

}
