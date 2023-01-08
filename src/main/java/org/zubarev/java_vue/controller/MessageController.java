package org.zubarev.java_vue.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zubarev.java_vue.domain.Message;
import org.zubarev.java_vue.repository.MessageRepo;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public Message getOneMessage(@PathVariable("id") Message message) {
        return message;

    }


    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageRepo.save(message);
    }


    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB,
                          @RequestBody Message messageFromUser) {
        BeanUtils.copyProperties(messageFromUser, messageFromDB, "id");
        return messageRepo.save(messageFromUser);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}
