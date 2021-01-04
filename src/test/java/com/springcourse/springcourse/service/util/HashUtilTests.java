package com.springcourse.springcourse.service.util;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HashUtilTests {

    @Test
    public void getSecurityHash(){
        String hash =  HashUtil.getSecurityHash("123");
        System.out.println(hash);

        assertThat(hash.length()).isEqualTo(64);
    }
}
