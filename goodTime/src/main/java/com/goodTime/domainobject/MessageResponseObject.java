package com.goodTime.domainobject;

import org.springframework.data.rest.core.config.Projection;

import com.goodTime.model.Message;
import com.goodTime.model.User;


@Projection(name="messageDetails", types= {Message.class})
public interface MessageResponseObject {
	
	String getText();
	User getUser();
}
