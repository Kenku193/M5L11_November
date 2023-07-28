package com.example.m5l11_november.controller;

import com.example.m5l11_november.entity.User;
import com.example.m5l11_november.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    @ResponseBody
    public ModelAndView showAllUsers(ModelAndView modelAndView){
        List<User> listOfUsers = userService.findAll();
        modelAndView.setViewName("userpage");
        modelAndView.addObject("users", listOfUsers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showOneUserAndAllUsers(ModelAndView modelAndView,
                                               @PathVariable(required = false) Long id){

        Optional<User> user = userService.findById(id);
        List<User> listOfUsers = userService.findAll();

        if(user.isPresent()){
            modelAndView.addObject("user", user.get());
            modelAndView.addObject("users", listOfUsers);
        }
        modelAndView.setViewName("userpage");
        return modelAndView;
    }


    @PostMapping("/{id}")
    public String updateOrDeleteUser(ModelAndView view,
                                     User user,
                                     @RequestParam(required = false) String deleteUser)
    {
        view.setViewName("userpage");
        if (Objects.nonNull(deleteUser)){
            userService.delete(user);
            return "redirect:/";
        }
        else {
            userService.update(user);
            return "redirect:/users/%d/".formatted(user.getId());
        }
    }

    @PostMapping
    public String createOrLoginUser(ModelAndView modelAndView,
                                    User user,
                                    @RequestParam(required = false) String createUser)
    {
        modelAndView.setViewName("userpage");
        if (Objects.nonNull(createUser)){
            userService.save(user);
            return "redirect:/users/%d/".formatted(user.getId());
        }
        else {
            System.out.println("User " + user.toString() + "logged on");
            return "redirect:/users";
        }
    }


//
//    @PostMapping("/")
//    public String processUser(ModelAndView view) {
//        view.setViewName("userpage");
//        return "redirect:http://www.yandex.ru";
//    }


}

//   HTTP        CRUD
// @PostMapping (Create)
// @GetMapping (Read)
// @PutMapping (Update)
// @DeleteMapping (Delete)