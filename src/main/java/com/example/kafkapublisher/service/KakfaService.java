package com.example.kafkapublisher.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KakfaService {
    
    
    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    
    public void sendMessage(String message)
    {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send("sai-topic", message);
        send.whenComplete((res,ex)->
        {
              if(ex==null)
              {
                  System.out.println("message sent successfully");
              }
              else{
                  System.out.println(ex);
              }
        });
    }
}
