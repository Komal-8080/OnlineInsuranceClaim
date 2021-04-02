package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.exceptions.UserException;
import com.onlineinsuranceclaim.model.UserData;
import com.onlineinsuranceclaim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String token,String subject,String text) {
        Long id = tokenUtil.decodeToken(token);
        Optional<UserData> userData = userRepository.findByUserId(id);

        System.out.println("User DATA "+userData);
        if(userData.isPresent()) {
            var mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userData.get().getEmail());
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            mailMessage.setFrom("shindekomal8080@gmail.com");
            javaMailSender.send(mailMessage);
        }
        else throw new UserException("Email Not Found");
    }

}
