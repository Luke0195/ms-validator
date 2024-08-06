package br.com.validator.validator.config.rabbitmq.consumer;

import br.com.validator.validator.model.Pedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Component
public class WorkerValidatorConsumer {

    private final  ObjectMapper objectMapper;


    @RabbitListener(queues = "${queue.name}")
    public void consume(@Payload Message message) throws IOException {
        Pedido pedido = objectMapper.readValue(message.getBody(), Pedido.class);
        log.info("Mensagem Recebida" + pedido.toString());

    }
}
