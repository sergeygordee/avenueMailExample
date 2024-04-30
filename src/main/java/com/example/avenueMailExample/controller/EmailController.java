package com.example.avenueMailExample.controller;

import com.example.avenueMailExample.entity.EmailForm;
import com.example.avenueMailExample.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email-form")
    public String showEmailForm(Model model){
        model.addAttribute("emailForm", new EmailForm());
        return "email-form";

    }

    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute("emailForm")EmailForm emailForm,
                            @RequestParam(value ="file", required = false)MultipartFile file) throws MessagingException {
        if (file != null && !file.isEmpty()){
            emailService.sendMailWithAttachment(emailForm.getEmail(), emailForm.getText(),emailForm.getSubject(), file);
            System.out.println("Выполнен метод с файлом");

        }
        else {
            emailService.sendMail(emailForm.getEmail(), emailForm.getSubject(), emailForm.getText());
            System.out.println("Выполнен метод без файла");
        }
        return "redirect:/email-sent";
    }

    @GetMapping("/email-sent")
    public String showEmailSentPage(){
        return "email-sent";
    }

//    @RequestMapping("/")
//    public String root() {
//        return "redirect:/index";
//    }
//
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }


}
