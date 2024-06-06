package com.pranav.driveportal.mailsendermicroservice.service;

import com.pranav.driveportal.mailsendermicroservice.model.MailModelAttachments;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;

@Service
public class MailWithAttachments {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    private File getFileFromMultipartFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

    public boolean sendMailWithAttachments(MailModelAttachments mailModelAttachments) throws MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setText(mailModelAttachments.getMessage());
        mimeMessageHelper.setSubject(mailModelAttachments.getTitle());

        if(!CollectionUtils.isEmpty(mailModelAttachments.getMailList())){
            for(MultipartFile attachment: mailModelAttachments.getFileList()){
                FileSystemResource fileSystemResource = new FileSystemResource(getFileFromMultipartFile(attachment));
                mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
            }
        }


        for(String emails:mailModelAttachments.getMailList()){
            mimeMessageHelper.setTo(emails);
            javaMailSender.send(mimeMessage);
        }


        return true;
    }

}
