package com.example.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LDC
 */
@RestController
public class ExampleController {

    @Resource
    private ChatModel chatModel;

    @GetMapping("/api/chat")
    ResponseEntity<?> chat(@RequestParam(required = false, defaultValue = "Hello AI") String text) {
        String result = chatModel.call(text);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/hello")
    ResponseEntity<?> hello(@RequestParam(required = false, defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name);
    }

}
