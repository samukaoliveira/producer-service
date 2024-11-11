package br.com.sti.producer.services;

import br.com.sti.commons.dtos.ProductDTO;
import br.com.sti.commons.constants.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import static br.com.sti.commons.constants.Constants.EXG_NAME_MARKETPLACE;
import static br.com.sti.commons.constants.Constants.RK_PRODUCT_LOG;
import static br.com.sti.commons.constants.Constants.QUEUE_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            byte[] message = objectMapper.writeValueAsBytes(dto);
            log.info("Sending a message to exchange" + dto.toString());
            rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
