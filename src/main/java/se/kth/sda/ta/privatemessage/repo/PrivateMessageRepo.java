package se.kth.sda.ta.privatemessage.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;
import se.kth.sda.ta.privatemessage.model.PrivateMessage;

public interface PrivateMessageRepo extends ReactiveMongoRepository<PrivateMessage, String> {
    @Tailable
    Flux<PrivateMessage> findWithTailableCursorByChannelId(String channelId);
}
