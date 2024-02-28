package com.codipster.mchinacommunity.repository;

import com.codipster.mchinacommunity.mongodocs.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}
