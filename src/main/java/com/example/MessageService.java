package com.example;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class MessageService {



    @Incoming("my-queue")
    public CompletionStage<Void> process(Message<String> message) {

        System.out.println("Message received "+message.getPayload());
        return message.ack();
    }

}