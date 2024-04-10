
package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.common.SpringResponse;
import com.rays.dto.UserDTO;

//combind 2 anotation 1.controller and 2nd is responsebody is for json format and api hit;
@RestController
@RequestMapping(value = "TestUser")
public class TestCtl {

	@GetMapping
	public SpringResponse display() {

		SpringResponse res = new SpringResponse();

		res.setData("data inserted");
		res.setMessage("successfully");

		Map errors = new HashMap();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login is required");
		errors.put("password", "password is required");

		Map map = new HashMap();
		map.put("inputerror", errors);

		res.setResult(map);

		return res;
	}

	@GetMapping("testORSResponse")
	public ORSResponse testORSResponse() {

		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login is required");
		errors.put("password", "password is required");

		res.addInputError(errors);

		res.addMessage("data inserted");

		UserDTO dto = new UserDTO();

	
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLoginId("abc@gmail.com");
		dto.setPassword("12345");

		res.addData(dto);
		res.addResult("preload", "user list");

		return res;
	}

}
