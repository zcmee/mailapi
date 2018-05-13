package com.github.zcmee.mailapi.dto;

import java.io.File;

public class MailAttachment {
    private String nameAttachment;
    private File attachment;

    public MailAttachment(String nameAttachment, File attachment) {
        this.nameAttachment = nameAttachment;
        this.attachment = attachment;
    }

    public String getNameAttachment() {
        return nameAttachment;
    }

    public void setNameAttachment(String nameAttachment) {
        this.nameAttachment = nameAttachment;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }
}