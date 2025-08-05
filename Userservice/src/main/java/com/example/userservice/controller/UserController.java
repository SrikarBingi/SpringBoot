package com.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.dto.OrderDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;


//import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@Value("${orserservice.url}")
	String orderservice;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value="/hello")
	public ResponseEntity<String> greet(){
		String resp = restTemplate.getForObject(orderservice+"/greet", String.class);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@GetMapping("/userdetails/{uid}")
	public ResponseEntity<UserDto> getUserDetails(@PathVariable Integer uid){
		UserDto userDto = new UserDto();

		User user = service.getUserById(uid);
		userDto.setUid(user.getUid());
		userDto.setUname(user.getUname());
		userDto.setAddr(user.getAddr());

		List<OrderDto> orders = restTemplate.getForObject(orderservice+"/orders/"+uid, List.class);
		userDto.setOrders(orders);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
		
	}

	@GetMapping(value="/greet")
	public ResponseEntity<String>  greet(String name) {
		
		return new ResponseEntity<String>("<h1>Hello There !!</h1>", HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/userpage/{pageNo}/{pageSize}")
	public ResponseEntity<List<User>> getUsersByPage(@PathVariable int pageNo,@PathVariable int pageSize){
		return new ResponseEntity<List<User>>(service.getUsersByPage(pageNo, pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/usersort/{sort}/{asc}")
	public ResponseEntity<List<User>> getUsersBySort(@PathVariable String sort, @PathVariable String asc){
		return new ResponseEntity<List<User>>(service.getUserBySort(sort,asc),HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid) {
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}
	
	@GetMapping("/username/{uname}")
	public ResponseEntity<User> getUserByName(@PathVariable String uname ) {
		return new ResponseEntity<User>(service.getUserByName(uname),HttpStatus.OK);
	}
	
	@GetMapping("/addr/{addr}")
	public ResponseEntity<List<User>> getUserByAddr(@PathVariable String addr ) {
		return new ResponseEntity<List<User>>(service.getUserByaddr(addr),HttpStatus.OK);
	}
	
	@GetMapping("/unameaddr/{uname}/{id}")
	public ResponseEntity<User> getUserByNameAndAddr(@PathVariable String uname,@PathVariable Integer id) {
		return new ResponseEntity<User>(service.getunameandaddr(uname,id),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<User> insertUser(@RequestBody User usr) {
		return new ResponseEntity<User>(service.insertUser(usr), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable int uid,@RequestBody User usr) {
		return new ResponseEntity<User>(service.updateUser(uid, usr),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid) {
		return new ResponseEntity<String>(service.deleteUser(uid), HttpStatus.ACCEPTED);
	}
	
}
