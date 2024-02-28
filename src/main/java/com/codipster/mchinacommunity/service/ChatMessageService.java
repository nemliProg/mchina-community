package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.mongodocs.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    ChatMessage save(ChatMessage chatMessage);

    List<ChatMessage> findChatMessages(String senderId, String recipientId);
}
