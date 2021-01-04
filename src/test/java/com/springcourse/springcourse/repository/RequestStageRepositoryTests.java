package com.springcourse.springcourse.repository;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestStage;
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
public class RequestStageRepositoryTests {

    @Autowired
    private RequestStageRepository requestStageRepository;

    @Test
    public void saveTest(){
        User owner = new User();
        owner.setId(1L);

        Request request = new Request();
        request.setId(1L);

        RequestStage requestStage = new RequestStage(null,"foi comprado um novo nootbook",new Date(), RequestState.CLOSED,request,owner);
        RequestStage createdStage = requestStageRepository.save(requestStage);

        assertThat(createdStage.getId()).isEqualTo(1L);

    }

    @Test
    public void getByIdTest(){
        Optional<RequestStage> result = requestStageRepository.findById(1L);
        RequestStage stage = result.get();

        assertThat(stage.getDescription()).isEqualTo("foi comprado um novo nootbook");
    }

    @Test
    public void listByRequestIdTest(){
        List<RequestStage> stages = requestStageRepository.findAllByRequestId(1L);

        assertThat(stages.size()).isEqualTo(1);
    }
}
