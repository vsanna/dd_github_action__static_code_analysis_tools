package dev.ishikawa.sca.sample.infrastructure.database;

import dev.ishikawa.sca.sample.domains.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageRepository extends JpaRepository<MessageEntity, Long>, JpaSpecificationExecutor<MessageEntity> {
    public MessageEntity findBySenderId(Long senderId);
    public MessageEntity findByReceiverId(Long receiverId);
}
