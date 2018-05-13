package com.github.zcmee.mailapi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MailUser {

    private String recipient;
    private String subject;
    private String sender;
    private Map<String, Object> contextVariables;
    private String nameTemplate;
    private List<MailAttachment> attachment;

    public MailUser() {
        attachment = new ArrayList<>();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Map<String, Object> getContextVariables() {
        return contextVariables;
    }

    public void setContextVariables(Map<String, Object> contextVariables) {
        this.contextVariables = contextVariables;
    }

    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    public List<MailAttachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(MailAttachment mailAttachment) {
        this.attachment.add(mailAttachment);
    }

    @Override
    public String toString() {
        return "MailUser{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", sender='" + sender + '\'' +
                ", contextVariables=" + contextVariables +
                ", nameTemplate='" + nameTemplate + '\'' +
                '}';
    }
}
