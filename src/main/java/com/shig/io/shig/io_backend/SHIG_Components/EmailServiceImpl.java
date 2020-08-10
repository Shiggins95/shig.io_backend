package com.shig.io.shig.io_backend.SHIG_Components;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

@Component
public class EmailServiceImpl {

  @Autowired
  private JavaMailSender emailSender;

  @Qualifier("freeMarkerConfiguration")
  @Autowired
  private Configuration FreemarkerConfig;

  public void sendSimpleMessage(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    System.out.println(message.getText());
    emailSender.send(message);
  }

  public void htmlEmail(Map model, String to, String templateName)
      throws MessagingException, IOException, TemplateException {

    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    Template template = FreemarkerConfig.getTemplate(templateName);

    String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    helper.setTo(to);
    helper.setText(html, true);
    helper.setSubject("Group Invitation");
    emailSender.send(message);
  }
}
