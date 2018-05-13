package com.github.zcmee.mailapi.controllers;

import com.github.zcmee.mailapi.api.Converter;
import com.github.zcmee.mailapi.dto.MailAttachment;
import com.github.zcmee.mailapi.dto.MailUser;
import com.github.zcmee.mailapi.services.EmailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

@Controller
@RequestMapping("testmail")
public class TestMailController {
    private final EmailServiceImpl emailServiceImpl;
    private final Converter<MultipartFile, File> multipartFileConverter;

    public TestMailController(EmailServiceImpl emailServiceImpl, Converter multipartFileConverter) {
        this.emailServiceImpl = emailServiceImpl;
        this.multipartFileConverter = multipartFileConverter;
    }

    @GetMapping("mailwithattachment")
    public String testUpload() {
        return "upload";
    }

    @ResponseBody
    @PostMapping("mailwithattachment")
    @ResponseStatus(HttpStatus.CREATED)
    public String testUploadFile(@RequestParam("file") MultipartFile file,
                                 @RequestParam("message") String message) throws MessagingException {

        MailUser mailUser = new MailUser();
        mailUser.setRecipient("recipent@gmail.com");
        mailUser.setSender("sender@marlenka.pl");
        mailUser.setSubject("Example Subject");
        mailUser.setNameTemplate("exampletemplate");
        mailUser.setContextVariables(Collections.singletonMap("name", "John Doe"));
        File attachemnt = multipartFileConverter.convert(file);
        mailUser.setAttachment(new MailAttachment(file.getOriginalFilename(), attachemnt));

        emailServiceImpl.sendSimpleMessage(mailUser);
        return "The mail has been sent correctly";
    }

    @GetMapping("send")
    @ResponseBody
    public String testMail() throws MessagingException, IOException {

        MailUser mailUser = new MailUser();
        mailUser.setRecipient("recipent@gmail.com");
        mailUser.setSender("rafatuskrolpolski@gmail.com");
        mailUser.setSubject("Example Subject");
        mailUser.setNameTemplate("exampletemplate");
        mailUser.setContextVariables(Collections.singletonMap("name", "John Doe"));

        emailServiceImpl.sendSimpleMessage(mailUser);
        return "The mail has been sent correctly";
    }

}
