package se.kth.sda.ta.globalchat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.kth.sda.ta.globalchat.model.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {
}
