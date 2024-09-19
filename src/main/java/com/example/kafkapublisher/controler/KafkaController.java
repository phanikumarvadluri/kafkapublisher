package com.example.kafkapublisher.controler;


import com.example.kafkapublisher.service.KakfaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KakfaService kakfaService;


    @GetMapping("/produce/{message}")
    public ResponseEntity<String> getMessage(@PathVariable String message)
    {
        kakfaService.sendMessage(message);
        return ResponseEntity.ok("Sent successfully");
    }
}
