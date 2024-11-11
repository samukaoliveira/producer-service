package br.com.sti.producer.services;

import br.com.sti.commons.dtos.ProductDTO;
import br.com.sti.producer.configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.sti.producer.configs.RabbitMQConfig.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
       log.info("Received message" + message);
       rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }
}
