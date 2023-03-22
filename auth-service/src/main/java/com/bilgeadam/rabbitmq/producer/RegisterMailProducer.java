package com.bilgeadam.rabbitmq.producer;

import com.bilgeadam.rabbitmq.model.RegisterMailModel;
import com.bilgeadam.rabbitmq.model.RegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMailProducer {

    @Value("${rabbitmq.exchange-auth}")
    private String directExchange;
    @Value("${rabbitmq.registermailkey}")
    private String registerMailBindingKey;

    private final RabbitTemplate rabbitTemplate;

    public void  sendActivationCode(RegisterMailModel model){
        rabbitTemplate.convertAndSend(directExchange,registerMailBindingKey,model);
    }


}
