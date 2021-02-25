package com.springcourse.springcourse.repository;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.domain.enums.RequestState;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RequestRepositoryTests {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest(){

        User owner = new User();
        owner.setId(1L);
        Request request = new Request(null,"computer","new computer",new Date(), RequestState.OPEN,owner,null,null);
        Request createdRequest = requestRepository.save(request);

        assertThat(createdRequest.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        User owner = new User();
        owner.setId(1L);
        Request request = new Request(null,"cellphone","new computer",new Date(), RequestState.OPEN,owner,null,null);
        Request updateRequested = requestRepository.save(request);

        assertThat(updateRequested.getSubject()).isEqualTo("cellphone");
    }

    @Test
    public void getByIdTest(){

        Optional<Request> result = requestRepository.findById(1L);
        Request findRequest = result.get();

        assertThat(findRequest.getId()).isEqualTo(1L);
    }

    @Test
    public void ListTest(){
        List<Request> requests = requestRepository.findAll();
        assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    public void ListByOwnerIdTest(){
        List<Request> ownerRequests = requestRepository.findAllByOwnerId(1L);
        assertThat(ownerRequests.size()).isEqualTo(1);
    }

    @Test
    public void updateStatusTest(){

         int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
         assertThat(affectedRows).isEqualTo(1);

    }
}
