package org.example.moreeduceorigin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        emailService.sendEmail("muhammadqodirmahmudjonov93@gmail.com", "something", "what's up");
    }
}
