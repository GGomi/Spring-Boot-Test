package com.essri.springweb.domain.posts;

import com.essri.springweb.web.posts.Posts;
import com.essri.springweb.web.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given : 테스트기반환경을 구축하는 단계
        postsRepository.save(Posts.builder()
            .title("테스트게시글")
                .content("테스트 본문")
                .author("dhkdn4042@gmail.com")
                .build()
        );

        //when : 테스트하고자하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        //then : 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록() {
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트게시글")
                .content("테스트 본문")
                .author("dhkdn4042@gmail.com")
                .build()
        );
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreateDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
