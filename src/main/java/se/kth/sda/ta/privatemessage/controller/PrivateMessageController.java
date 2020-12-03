package se.kth.sda.ta.privatemessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.kth.sda.ta.auth.AuthService;
import se.kth.sda.ta.privatemessage.model.PrivateMessage;
import se.kth.sda.ta.privatemessage.repository.PrivateMessageRepository;
import se.kth.sda.ta.privatemessage.service.PrivateMessageService;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;

import javax.validation.Valid;
import java.time.Duration;

@RestController
@RequestMapping("/message")
public class PrivateMessageController {

    private final PrivateMessageService privateMessageService;
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public PrivateMessageController(PrivateMessageRepository repository, PrivateMessageService privateMessageService, AuthService authService, UserService userService) {
        this.privateMessageService = privateMessageService;
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PrivateMessage> postMessage(@Valid @RequestBody PrivateMessage message) {
        // Set sender details in backend to avoid shenanigans
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        message.setSenderEmail(loggedInUser.getEmail());
        message.setSenderName(loggedInUser.getName());
        message.setAuthor(loggedInUser.getName());
        return privateMessageService.postMessage(message);
    }

    // Stream messages with your email address in sender field.
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PrivateMessage> streamMessages() {
        return privateMessageService.streamMessagesFromRepo(authService.getLoggedInUserEmail())
                // Merge with an 40 second interval flux stream to keep client alive.
                .mergeWith(Flux.interval(Duration.ofSeconds(40), Duration.ofSeconds(40))
                        .map(ignored ->
                        {
                            PrivateMessage heartbeat = new PrivateMessage();
                            heartbeat.setId("heartbeat");
                            return heartbeat;
                        }));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
        privateMessageService.delete(id);
    }
}