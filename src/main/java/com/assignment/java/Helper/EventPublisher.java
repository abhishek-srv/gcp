package com.assignment.java.Helper;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import com.assignment.java.DTO.ProductEvents;
import com.assignment.java.Models.Product;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.gson.Gson;
import java.time.Instant;

@Component
@ConditionalOnBean(PubSubTemplate.class)
public class EventPublisher 
{
    private final PubSubTemplate pubSubTemplate;
    private final Gson gson = new Gson();

    public EventPublisher(PubSubTemplate pubSubTemplate) 
    {
        this.pubSubTemplate = pubSubTemplate;
    }

    public void publishProductEvent(String eventType, Product product) 
    {
        ProductEvents event = new ProductEvents(eventType, Instant.now().toString(), product);
        String message = gson.toJson(event);
        pubSubTemplate.publish("product-events", message);
    }
}