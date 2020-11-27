package se.kth.sda.ta.privatemessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.kth.sda.ta.privatemessage.model.PrivateMessage;
import se.kth.sda.ta.privatemessage.repo.PrivateMessageRepo;

import javax.validation.Valid;

@RestController
public class PrivateMessageController {

    private final PrivateMessageRepo repository;

    @Autowired
    public PrivateMessageController(PrivateMessageRepo repository) {
        this.repository = repository;
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@Valid @RequestBody PrivateMessage message) {
        repository.save(message).subscribe();
    }

    @GetMapping(value = "/message/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PrivateMessage> streamMessages(@RequestParam String channelId) {
        return repository.findWithTailableCursorByChannelId(channelId);
    }
}
