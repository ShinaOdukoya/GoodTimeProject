package com.goodTime.service;

import java.util.List;
import com.goodTime.model.Message;
import com.goodTime.model.User;

public interface MessageService {
	
	void createMessage(Message message);
	void deleteMessage(long id);
	Message findMessage(long id);
	Message updateMessage(Message message, long id);
	List<Message> findAllMessages();
}
