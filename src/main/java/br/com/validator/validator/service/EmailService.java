package br.com.validator.validator.service;

import br.com.validator.validator.config.email.EmailConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
;

import org.springframework.stereotype.Service;


@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Slf4j
@Service
public class EmailService {


    private EmailConfig emailConfig;

    public void notificarCliente(String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Compra Aprovada");
        message.setText("Este é um e-mail de confimação de compra aprovada." + "Sua compra foi realizada com sucesso. Em breve você recebera um código de rastreio do seu produto." + "\n Obrigado por comprar com a gente!!");
        emailConfig.mailSender().send(message);
        log.info("Cliente notificado com sucesso!");
    }
}
