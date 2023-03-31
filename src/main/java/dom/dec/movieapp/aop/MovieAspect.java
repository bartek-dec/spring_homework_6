package dom.dec.movieapp.aop;

import dom.dec.movieapp.service.EmailService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieAspect {
    private EmailService emailService;

    @Autowired
    public MovieAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @After("@annotation(AddMovieAnnotation)")
    public void sendEmail() {
        emailService.sendMessage();
    }
}
