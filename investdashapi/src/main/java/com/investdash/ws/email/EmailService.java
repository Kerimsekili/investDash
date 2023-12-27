package com.investdash.ws.email;

import com.investdash.ws.configuration.InvestdashProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    JavaMailSenderImpl mailSender;

    @Autowired
    InvestdashProperties investdashProperties;

    @PostConstruct
    public void initialize() {
        this.mailSender = new JavaMailSenderImpl();
        mailSender.setHost(investdashProperties.getEmail().host());
        mailSender.setPort(investdashProperties.getEmail().port());
        mailSender.setUsername(investdashProperties.getEmail().username());
        mailSender.setPassword(investdashProperties.getEmail().password());

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
    }

    public void sendActivationEmail(String email, String activationToken) {
        var activationUrl = investdashProperties.getClient().host() + "/activation/" + activationToken;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(investdashProperties.getEmail().from());
        message.setTo(email);
        message.setSubject("Account Activation");
        message.setText(activationUrl);
        this.mailSender.send(message);
    }

}
