package com.pranav.driveportal.mailsendermicroservice.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

public class MailModelAttachments {

    private String message;
    private String title;
    private List<MultipartFile> fileList= new LinkedList<>();

    private  List<String> mailList = new LinkedList<>();

    public MailModelAttachments(String message, String title, List<MultipartFile> fileList, List<String> mailList) {
        this.message = message;
        this.title = title;
        this.fileList = fileList;
        this.mailList = mailList;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MultipartFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<MultipartFile> fileList) {
        this.fileList = fileList;
    }

    public List<String> getMailList() {
        return mailList;
    }

    public void setMailList(List<String> mailList) {
        this.mailList = mailList;
    }
}
