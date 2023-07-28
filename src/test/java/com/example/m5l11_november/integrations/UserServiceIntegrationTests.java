package com.example.m5l11_november.integrations;

import com.example.m5l11_november.entity.User;
import com.example.m5l11_november.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


@RequiredArgsConstructor
@TestContext
public class UserServiceIntegrationTests {

    private final UserService userService;

    @Test
    void findById(){
        User user = userService.findById(9L).orElseThrow();
        Assertions.assertEquals(9L, user.getId());
        // ПИШЕМ ПРОВЕРКИ НА ДРУГИЕ ПОЛЯ
    }

    @Test
    void findAll(){
        List<User> all = userService.findAll();
        Assertions.assertEquals(4, all.size());
    }

    @Test
    void save() {
        User savedUser = userService
                .save(User
                        .builder()
                        .id(999L)
                        .login("savedUser")
                        .password("savedPasswprd")
                        .build());

     Assertions.assertEquals("savedUser", savedUser.getLogin());
    }

    @Test
  //  @Sql(statements = "delete from users where id=11")
    void deleteById() {
     userService.deleteById(9L);
        List<User> all = userService.findAll();
        Assertions.assertEquals(3, all.size());
    }

}
