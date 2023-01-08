package org.zubarev.java_vue.controller;

import org.springframework.web.bind.annotation.*;
import org.zubarev.java_vue.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {
    private int counter = 4;
    private List <Map <String, String>> messages = new ArrayList<>(){{
        add(new HashMap<String,String>() {{put("id", "1"); put("text","first message");}});
        add(new HashMap<String,String>() {{put("id", "2"); put("text","second message");}});
        add(new HashMap<String,String>() {{put("id", "3"); put("text","third message");}});
    }};
    @GetMapping
    public List<Map<String, String>> list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOneMessage (@PathVariable String id){
    return getMesssage(id);

    }

    private Map<String, String> getMesssage(String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst().orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map <String,String> createMessage(@RequestBody Map<String,String> message){
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    @PutMapping("{id}")
    public Map <String,String> update(@PathVariable String id,@RequestBody Map<String,String> message){
       Map <String,String> messageFromDB =  getMesssage(id);
       messageFromDB.putAll(message);
       messageFromDB.put("id",id);
       return messageFromDB;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String,String> message = getMesssage(id);
        messages.remove(message);
    }
}
