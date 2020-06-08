package com.goodTime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodTime.model.Message;
import com.goodTime.serviceImplementation.MessageServiceImpl;

@RestController
@RequestMapping("api/messages")
public class MessageController {
	
	@Autowired
	private MessageServiceImpl messageService;
	
	@PostMapping("/")
	public ResponseEntity<Message> createMessage(@RequestBody Message message){
		messageService.createMessage(message);
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Message>> getAllMessages(){
		List<Message> messages =messageService.findAllMessages();
		return new ResponseEntity<List<Message>>(messages, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") long id){
		Message message = messageService.findMessageById(id);
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Message> deleteMessage(@PathVariable("id") long id){
		messageService.deleteMessage(id);
		return new ResponseEntity<Message>(HttpStatus.OK);
	}
}
