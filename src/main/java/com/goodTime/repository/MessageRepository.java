package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.goodTime.domainobject.MessageResponseObject;
import com.goodTime.model.Message;

@Repository
@RepositoryRestResource(collectionResourceRel = "messages", path="messages", excerptProjection=MessageResponseObject.class)
public interface MessageRepository extends JpaRepository<Message, Long>{

}
