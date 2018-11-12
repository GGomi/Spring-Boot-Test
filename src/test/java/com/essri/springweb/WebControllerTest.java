package com.essri.springweb;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {

    @Autowired
    private TestRestTemplate rstTemplate;

    @Test
    public void 메인페이지_로딩() {
        // when
        String body = this.rstTemplate.getForObject("/",String.class);

        //then
        Assertions.assertThat(body).contains("스프링부트 게시판");
    }
}
