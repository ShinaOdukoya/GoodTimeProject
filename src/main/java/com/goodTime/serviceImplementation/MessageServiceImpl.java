package com.goodTime.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Message;
import com.goodTime.repository.MessageRepository;
import com.goodTime.repository.UserRepository;
import com.goodTime.service.MessageService;


@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createMessage(Message message) {
		messageRepository.save(message);	
	}

	@Override
	public void deleteMessage(long id) {
		findMessageById(id);
		messageRepository.deleteById(id);
	}

	@Override
	public Message findMessageById(long id) {
		return messageRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("User with ID "+id+" does not exist!"));
	}

	@Override
	public Message updateMessage(Message message, long id) {
		return messageRepository.saveAndFlush(message);
	}

	@Override
	public List<Message> findAllMessages(){
		if(messageRepository.findAll().isEmpty()) {
			throw new NotFoundException("Message table is empty!");
		}
		return messageRepository.findAll();
	}
}
