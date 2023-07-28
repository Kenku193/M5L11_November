package com.example.m5l11_november;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppMVC {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AppMVC.class, args);

//        UserService userService = run.getBean(UserService.class);
//        List<User> all = userService.findAll();
//        for (User user : all) {
//            System.out.println(user);
//        }
//
//        User user = userService.findById(1L).orElseThrow();
//        System.out.println(user);



    }
}
