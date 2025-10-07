package vn.iotstar.chatsupport.repository;

import vn.iotstar.chatsupport.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByRoomIdOrderByTimestampAsc(String roomId);
}
