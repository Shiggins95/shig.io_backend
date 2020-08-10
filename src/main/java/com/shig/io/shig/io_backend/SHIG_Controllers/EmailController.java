package com.shig.io.shig.io_backend.SHIG_Controllers;

import com.shig.io.shig.io_backend.SHIG_Components.EmailServiceImpl;
import freemarker.template.TemplateException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/email")
public class EmailController {

  @Autowired EmailServiceImpl emailService;

  private final String devUrl = "http://localhost:3000";
  private final String prodUrl = "http://shig.io";

  @GetMapping(value = "/")
  public String hello() {
    return "Hello, World!";
  }

  @Transactional
  @CrossOrigin(origins = {devUrl, prodUrl})
  @PostMapping(value = "/send_email")
  public void sendEmail(@RequestBody JSONObject body)
      throws MessagingException, IOException, TemplateException {
    System.out.println("attempt");

    String email = "stephen.higgins1995@gmail.com";

    String firstName = body.getAsString("first_name");
    String lastName = body.getAsString("last_name");
    String fullName = firstName + " " + lastName;
    String contactEmail = body.getAsString("email");
    String contactMobile = body.getAsString("mobile");
    String preferredContactMethod = body.getAsString("preferred_contact");
    String actualPreferredContactMethod = body.getAsString(preferredContactMethod);
    String budget = body.getAsString("budget");
    String deadline = body.getAsString("deadline");
    String contactReason = body.getAsString("contact_reason");
    String noOfPages = body.getAsString("no_of_pages");
    String dbRequired = body.getAsString("db_required");
    String usersRequired = body.getAsString("users_required");
    String domainPurchased = body.getAsString("domain_purchased");

    String subject = "SHIG.io enquiry from " + fullName + " - " + contactReason;

    Map model = new HashMap();
    model.put("name", fullName);
    model.put("email", contactEmail);
    model.put("mobile", contactMobile);
    model.put("preferred_contact", actualPreferredContactMethod);
    model.put("budget", budget);
    model.put("deadline", deadline);
    model.put("contact_reason", contactReason);
    model.put("no_of_pages", noOfPages);
    model.put("db_required", dbRequired);
    model.put("users_required", usersRequired);
    model.put("domain_purchased", domainPurchased);

    emailService.htmlEmail(model, email, "SHIG_Enquiry_Template.ftl");
  }
}
