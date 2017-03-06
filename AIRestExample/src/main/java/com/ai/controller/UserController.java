package com.ai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ai.model.User;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private User getUsers(@RequestParam(value="userId")int userId)
	{
	    final String uri = "https://jsonplaceholder.typicode.com//posts?userId="+userId;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    User result = restTemplate.getForObject(uri, User.class);
	    return result;
	}
	
	@RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	private void createUsers()
	{
		final String uri = "https://jsonplaceholder.typicode.com//posts";
		User newUser = new User(1001, 1,"head","");
	    RestTemplate restTemplate = new RestTemplate();
	    User result = restTemplate.postForObject( uri, newUser, User.class);
	}
	
	@RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	private  void updateEmployee()
	{
	    final String uri = "https://jsonplaceholder.typicode.com//posts/"+1;
	    User updateUser = new User(1001, 1,"lead","");	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put ( uri, updateUser);
	}
	
	@RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	private static void deleteUsers()
	{
	    final String uri = "http://localhost:8080/springrestexample/employees/{id}";
	    User user=new User();
	    user.setId(1);
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete ( uri,  user );
	}
}
