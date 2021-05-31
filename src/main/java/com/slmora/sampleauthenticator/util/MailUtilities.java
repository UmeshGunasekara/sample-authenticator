/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/31/2021 1:49 AM
 */
package com.slmora.sampleauthenticator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/31/2021 1:49 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/31/2021      SLMORA                Initial Code
 */
@Component
public class MailUtilities
{

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String recipientEmail, String resetToken)
            throws MessagingException, UnsupportedEncodingException
    {
        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@slmora.com", "Application Support");
        helper.setTo(recipientEmail);
        helper.setSubject("reset your password");

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p>Use the Reset Code: <strong>\"" + resetToken + "\"</strong></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setText(content, true);
//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        mailSender.send(message);
    }
}
