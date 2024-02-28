package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.mongodocs.ChatRoom;
import com.codipster.mchinacommunity.repository.ChatRoomRepository;
import com.codipster.mchinacommunity.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImp implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    @Override
    public Optional<String> getChatRoomId(String senderId, String receiverId, boolean createIfNotExists) {
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId, receiverId)
                .map(ChatRoom::getId)
                .or(() -> {
                    if (createIfNotExists) {
                        var chatId = createChatRoomId(senderId, receiverId);
                        return Optional.of(chatId);
                    } else {
                        return Optional.empty();
                    }
                });
    }

    private String createChatRoomId(String senderId, String receiverId) {
        String ChatId = String.format("%s_%s", senderId, receiverId);
        ChatRoom senderRecipient = ChatRoom.builder()
                .id(ChatId)
                .senderId(senderId)
                .recipientId(receiverId)
                .build();
        ChatRoom recipientSender = ChatRoom.builder()
                .id(ChatId)
                .senderId(receiverId)
                .recipientId(senderId)
                .build();
        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return ChatId;
    }
}
