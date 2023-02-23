//package com.codeup.codeupspringblog.services;
//
//import com.codeup.codeupspringblog.controllers.Post;
//import com.sendgrid.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service("EmailService")
//public class EmailService {
//
//    @Value("${spring.sendgrid.api-key}")
//    private String apiKey;
//    public String sendTextEmail(Post post) throws IOException {
//        Email from = new Email("silvamatias03@gmail.com");
//        String subject = "New Post has been created!";
//        Email to = new Email(post.getUser().getEmail());
//        Content content = new Content("text/plain", "Thank you for submitting a new post.");
//        Mail mail = new Mail(from, subject, to, content);
//
//        SendGrid sg = new SendGrid(apiKey);
//
//        Request request = new Request();
//
//        try{
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setbody(mail.build());
//            Response response = sg.api(request);
//            return response.getBody();
//        } catch(IOException ex) {
//            return ex.getMessage();
//        }
//    }
//}
