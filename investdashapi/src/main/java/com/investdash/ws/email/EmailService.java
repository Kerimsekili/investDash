package com.investdash.ws.email;

import com.investdash.ws.configuration.InvestdashProperties;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Properties;

@Service
public class EmailService {

    JavaMailSenderImpl mailSender;

    @Autowired
    InvestdashProperties investdashProperties;

    @Autowired
    MessageSource messageSource;

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

    String activationEmail = """
            <html>
            <body>
            <h1>${title}</h1>
            <a href="${url}">${clickHere}</a>
            </body>
            </html>
            """;

    public void sendActivationEmail(String email, String activationToken) {
        var activationUrl = investdashProperties.getClient().host() + "/activation/" + activationToken;
        var title = messageSource.getMessage("investdash.mail.user.created.title", null, LocaleContextHolder
                .getLocale());
        var clickHere = messageSource.getMessage("investdash.mail.click.here", null, LocaleContextHolder.getLocale());


        var mailBody = activationEmail
                .replace("${url}", activationUrl)
                .replace("${title}",title)
                .replace("${clickHere}",clickHere);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage,"UTF-8");
        try {
            message.setFrom(investdashProperties.getEmail().from());
            message.setTo(email);
            message.setSubject("Account Activation");
            message.setText(mailBody, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        this.mailSender.send(mimeMessage);
    }

}
