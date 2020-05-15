package com.goodTime.service;

import java.util.List;
import com.goodTime.model.Message;

public interface MessageService {
	
	void createMessage(Message message);
	void deleteMessage(long id);
	Message findMessageById(long id);
	Message updateMessage(Message message, long id);
	List<Message> findAllMessages();
}
