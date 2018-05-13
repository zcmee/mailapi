package com.github.zcmee.mailapi.services;

import com.github.zcmee.mailapi.dto.MailAttachment;
import com.github.zcmee.mailapi.dto.MailUser;
import com.github.zcmee.mailapi.mail.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl {
    private final JavaMailSender javaMailSender;
    private final MailContentBuilder mailContentBuilder;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender, MailContentBuilder mailContentBuilder) {
        this.javaMailSender = javaMailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    public void sendSimpleMessage(MailUser mailUser) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, StandardCharsets.UTF_8.name());
        String html = mailContentBuilder.build(mailUser.getNameTemplate(), mailUser.getContextVariables());
        helper.setTo(mailUser.getRecipient());
        helper.setText(html, true);
        helper.setSubject(mailUser.getSubject());
        helper.setFrom(mailUser.getSender());

        for(MailAttachment mailAttachment : mailUser.getAttachment()) {
            helper.addAttachment(mailAttachment.getNameAttachment(), mailAttachment.getAttachment());
        }

        javaMailSender.send(message);
    }
}
