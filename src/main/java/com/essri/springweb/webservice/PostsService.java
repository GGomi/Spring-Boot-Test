package com.essri.springweb.webservice;

import com.essri.springweb.web.posts.PostsRepository;
import com.essri.springweb.web.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    // Exception이 발생하면 모든 DB작업을 초기화시킴. 등록/수정/삭제시 필수
    @Transactional
    public long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
