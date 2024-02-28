package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.service.ChatRoomService;

import java.util.Optional;

public class ChatRoomServiceImp implements ChatRoomService {
    @Override
    public Optional<String> getChatRoomId(String senderId, String receiverId, boolean createIfNotExists) {
        return Optional.empty();
    }
}
