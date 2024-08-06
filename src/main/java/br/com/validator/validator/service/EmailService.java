package br.com.validator.validator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void notificarCliente(String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Compra Aprovada");
        message.setText("Este é um e-mail de confimação de compra aprovada." + "Sua compra foi realizada com sucesso. Em breve você recebera um código de rastreio do seu produto." + "\n Obrigado por comprar com a gente!!");
        javaMailSender.send(message);
        log.info("Cliente notificado com sucesso!");
    }
}
