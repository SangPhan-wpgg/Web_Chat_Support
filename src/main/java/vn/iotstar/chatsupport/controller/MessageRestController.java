package vn.iotstar.chatsupport.controller;

import org.springframework.web.bind.annotation.*;
import vn.iotstar.chatsupport.entity.MessageEntity;
import vn.iotstar.chatsupport.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {
    private final MessageService service;

    public MessageRestController(MessageService service) {
        this.service = service;
    }

    // API: GET /api/messages/{roomId}
    @GetMapping("/{roomId}")
    public List<MessageEntity> getMessages(@PathVariable String roomId) {
        return service.getMessages(roomId);
    }
}
