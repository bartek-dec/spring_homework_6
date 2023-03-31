package dom.dec.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("springEmail@gmail.com");
        mailMessage.setTo("decbartek@gmail.com");
        mailMessage.setSubject("New movie");
        mailMessage.setText("New movie has been added");

        mailSender.send(mailMessage);
    }
}
