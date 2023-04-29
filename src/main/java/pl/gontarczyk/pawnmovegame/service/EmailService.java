package pl.gontarczyk.pawnmovegame.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final GifService gifService;

    @Scheduled(cron = "0 0 17 * * MON-FRI")
    public void sendMailWithAttachment() throws MessagingException, IOException {
        MimeMessage sender = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(sender, true);

        helper.setTo("konrad326@opoczta.pl");
        helper.setSubject("Today's pawn movement.");
        helper.setText("The gif is in the attachment.");

        java.io.File file = File.createTempFile("PawnMovement", "gif");
        gifService.createGif(file);
        helper.addAttachment("PawnMovement.gif", new FileSystemResource(file));
        file.deleteOnExit();

        emailSender.send(sender);
    }
}