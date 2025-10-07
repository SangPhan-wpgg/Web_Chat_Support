package vn.iotstar.chatsupport.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import vn.iotstar.chatsupport.model.ChatMessage;
import vn.iotstar.chatsupport.service.MessageService;

@Controller
public class SupportController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;

    public SupportController(SimpMessagingTemplate messagingTemplate, MessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/support.send")
    public void send(@Payload ChatMessage message) {
        message.setTimestamp(System.currentTimeMillis());
        // lưu DB
        messageService.save(message.getRoomId(), message.getFrom(), message.getContent(), message.getTimestamp());
        // gửi tới mọi client
        messagingTemplate.convertAndSend("/topic/room." + message.getRoomId(), message);
    }

    @MessageMapping("/support.join")
    public void join(@Payload ChatMessage message) {
        message.setType(ChatMessage.Type.JOIN);
        message.setTimestamp(System.currentTimeMillis());
        messagingTemplate.convertAndSend("/topic/room." + message.getRoomId(), message);
    }
}
