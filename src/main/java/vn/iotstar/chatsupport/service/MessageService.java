package vn.iotstar.chatsupport.service;

import vn.iotstar.chatsupport.entity.MessageEntity;
import vn.iotstar.chatsupport.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repo;

    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }

    public MessageEntity save(String roomId, String sender, String content, long timestamp) {
        return repo.save(new MessageEntity(roomId, sender, content, timestamp));
    }

    public List<MessageEntity> getMessages(String roomId) {
        return repo.findByRoomIdOrderByTimestampAsc(roomId);
    }
}
