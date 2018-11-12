package com.essri.springweb.sevice;

import com.essri.springweb.web.posts.Posts;
import com.essri.springweb.web.posts.PostsRepository;
import com.essri.springweb.web.posts.PostsSaveRequestDto;
import com.essri.springweb.webservice.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void dto데이터가_posts테이블에_저장 () {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("dhkdn4042@gmail.com")
                .content("테스트")
                .title("title")
                .build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo((dto.getTitle()));
    }
}
