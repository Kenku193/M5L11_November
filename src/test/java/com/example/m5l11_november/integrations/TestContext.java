package com.example.m5l11_november.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest
@TestConfiguration
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
@ActiveProfiles("test")
public @interface TestContext {
}
