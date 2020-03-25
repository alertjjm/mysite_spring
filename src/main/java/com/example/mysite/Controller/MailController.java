package com.example.mysite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MailController {
    @Autowired
    private JavaMailSender mailSender;
    @RequestMapping("/contact")
    public String mailSending(HttpServletRequest request){
        String setfrom = request.getParameter("email");
        String tomail = "sdr2936@gmail.com";// 받는 사람 이메일
        String title = request.getParameter("name"); // 제목
        String content = request.getParameter("message"); // 내용

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(setfrom+"\n"+content); // 메일 내용

            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "/contact";
    }
}
