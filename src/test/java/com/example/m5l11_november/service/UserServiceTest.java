package com.example.m5l11_november.service;

import com.example.m5l11_november.entity.User;
import com.example.m5l11_november.repository.Repo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    Repo repo;

    @InjectMocks
    UserService userService;

    private User buildedUser;

    @BeforeEach
    void setup(){
        buildedUser = User.builder()
                .id(1L)
                .login("buildedLogin")
                .password("buildedPassword")
                .build();
    }

    @Test
    void findById() {
        // given
        Mockito
                .doAnswer(invocationOnMock -> Optional.of(buildedUser))
                .when(repo)
                .findById(1L);
        // when
        Optional<User> byId = userService.findById(1L);
        //then
        Assertions.assertTrue(byId.isPresent());
        // verify
        Mockito.verify(repo, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(repo);
    }

    @Test
    void findAll() {
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(buildedUser));
        List<User> listUsers = userService.findAll();

        Assertions.assertEquals(1, listUsers.size());
        Assertions.assertEquals("buildedLogin", listUsers.get(0).getLogin());
        Mockito.verifyNoMoreInteractions(repo);
    }

    @Test
    void save() {
        Mockito.doAnswer(invocationOnMock -> User
                .builder()
                .id(999L)
                .login("savedUser")
                .password("savedPassword")
                .build())
                        .when(repo).save(buildedUser);

        userService.save(buildedUser);
        Mockito.verify(repo, Mockito.times(1)).save(buildedUser);

    }

    @Test
    void update() {
    }

    @Test
    void delete() {

    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(repo).deleteById(1L);
        userService.deleteById(1L);
        Mockito.verify(repo, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void findByLoginAndPassword() {
    }
}