package se.kth.sda.ta.globalchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.kth.sda.ta.globalchat.model.Chat;
import se.kth.sda.ta.globalchat.repository.ChatRepository;

import java.util.List;

@RestController
@RequestMapping("chat")
public class ChatRestController {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatRestController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping("")
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }
}
