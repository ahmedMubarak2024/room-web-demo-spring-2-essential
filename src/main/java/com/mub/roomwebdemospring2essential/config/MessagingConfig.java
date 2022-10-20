package com.mub.roomwebdemospring2essential.config;

import com.mub.roomwebdemospring2essential.asyc.MessageListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    public final static String QUEUE_KEY = "My Queue";
    public final static String TOPIC_KEY = "My TOPIC";
    public final static String ROUTING_KEY = "com.mub.roomwebdemospring2essential";

    @Bean
    public Queue createQueue() {
        return new Queue(QUEUE_KEY);
    }

    @Bean
    public TopicExchange createTopic() {
        return new TopicExchange(TOPIC_KEY);
    }

    @Bean
    public Binding bindQueueAndKey(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageListenerAdapter createMessageListener(MessageListener listener) {
        return new MessageListenerAdapter(listener);
    }

    @Bean
    public SimpleMessageListenerContainer createMessageListenerContainer(MessageListenerAdapter listenerAdapter, ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(QUEUE_KEY);
        return simpleMessageListenerContainer;
    }
}
