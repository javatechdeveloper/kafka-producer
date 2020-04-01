package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@RequestMapping("produce")
public class ProducerController {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	@GetMapping("/{name}")
	public String produce(@PathVariable String name) {
		User user= new User(name, "12");
		kafkaTemplate.send("test", user);
		return "produced";
	}
}
