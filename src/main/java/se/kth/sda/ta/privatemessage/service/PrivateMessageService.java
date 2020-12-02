package se.kth.sda.ta.privatemessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.kth.sda.ta.privatemessage.model.PrivateMessage;
import se.kth.sda.ta.privatemessage.repository.PrivateMessageRepository;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserRepository;

import javax.validation.Valid;
import java.time.Duration;

@Service
public class PrivateMessageService {

    private final PrivateMessageRepository privateMessageRepository;
    private final UserRepository userRepository;

    @Autowired
    public PrivateMessageService(PrivateMessageRepository repository, UserRepository userRepository) {
        this.privateMessageRepository = repository;
        this.userRepository = userRepository;
    }

    public Mono<PrivateMessage> postMessage(@Valid @RequestBody PrivateMessage message) {
        // Find receiver by Email and set receiver name
        User receiver = userRepository.findByEmail(message.getReceiverEmail());
        message.setReceiverName(receiver.getName());
        // Create copy for receiver (Flip the sender and receiver)
        PrivateMessage duplicate = new PrivateMessage(
                null,
                message.getContent(),
                message.getReceiverName(),
                message.getReceiverEmail(),
                message.getSenderName(),
                message.getSenderEmail(),
                message.getDate(),
                message.getAuthor()
                );

        // Save the duplicate to the repo
        privateMessageRepository.save(duplicate).toProcessor();
        // Save the original message to the repo, toProcessor will sub and return the Mono.
        return privateMessageRepository.save(message).toProcessor();
    }

    // Stream messages from the repo with email in sender field.
    public Flux<PrivateMessage> streamMessagesFromRepo(String senderEmail) {
        return privateMessageRepository.findWithTailableCursorBySenderEmail(senderEmail);

    }

    public void delete(String id) {
        privateMessageRepository.deleteById(id);
    }
}
