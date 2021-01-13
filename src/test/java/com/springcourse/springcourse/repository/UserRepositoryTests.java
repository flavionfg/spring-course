package com.springcourse.springcourse.repository;

import com.springcourse.springcourse.domain.enums.Role;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springcourse.springcourse.domain.User;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


   @Ignore
    public void saveTest(){
       User user = new User(null,"Kevin", "kevin.wingi@gmail.com", "123", Role.ADMINISTRATOR, null, null);
       User createdUser = userRepository.save(user);

        assertThat(createdUser.getId()).isEqualTo(1L);

    }

    @Ignore
    public void updateTest(){
        User user = new User(1L,"Kevin wing","kevin.wingi@gmail.com","123",Role.ADMINISTRATOR,null,null);
        User updatedUser = userRepository.save(user);

        assertThat(updatedUser.getName()).isEqualTo("Kevin wing");
    }

    @Ignore
    public void getByIdTest(){
      Optional<User> result = userRepository.findById(1L);
      User user = result.get();

      assertThat(user.getPassword()).isEqualTo("123");
    }

    @Ignore
    public void listTest(){
        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
    }

    @Ignore
    public void loginTest(){
        Optional<User> result = userRepository.login("kevin.wingi@gmail.com","123");
        User loggedUser = result.get();

        assertThat(loggedUser.getId()).isEqualTo(1L);
    }

    @Test
    public void updateRoleTest() {
        int affectedRows = userRepository.updateRole(11L, Role.ADMINISTRATOR);
        assertThat(affectedRows).isEqualTo(1);
    }

}
