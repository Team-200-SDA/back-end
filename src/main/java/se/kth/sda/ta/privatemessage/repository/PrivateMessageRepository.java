package se.kth.sda.ta.privatemessage.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;
import se.kth.sda.ta.privatemessage.model.PrivateMessage;

public interface PrivateMessageRepository extends ReactiveMongoRepository<PrivateMessage, String> {
    // Open a stream to mongoDB and monitor changes. This is asynchronous.
    // Would you look at that method name... 👀
    @Tailable
    Flux<PrivateMessage> findWithTailableCursorBySenderEmailAndSubscribedIsTrue(String senderEmail);
}
