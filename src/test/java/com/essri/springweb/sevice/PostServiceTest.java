package com.essri.springweb.sevice;

import com.essri.springweb.web.posts.Posts;
import com.essri.springweb.web.posts.PostsMainResponseDto;
import com.essri.springweb.web.posts.PostsRepository;
import com.essri.springweb.web.posts.PostsSaveRequestDto;
import com.essri.springweb.webservice.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void posts테이블_조회 () {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("test1@gmail.com")
                .content("test1의 본문")
                .title("test1")
                .build();

        PostsSaveRequestDto dto2 = PostsSaveRequestDto.builder()
                .author("test2@gmail.com")
                .content("test2의 본문")
                .title("test2")
                .build();

        List<PostsSaveRequestDto> set = new ArrayList<>();
        set.add(dto2);
        set.add(dto);

        // when
        List<PostsMainResponseDto> list = postsService.findAllDesc();

        for(int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).getAuthor()).isEqualTo(set.get(i).getAuthor());
            assertThat(list.get(i).getTitle()).isEqualTo(set.get(i).getTitle());
        }


    }
}
