package com.essri.springweb.webservice;

import com.essri.springweb.web.posts.PostsMainResponseDto;
import com.essri.springweb.web.posts.PostsRepository;
import com.essri.springweb.web.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    // Exception이 발생하면 모든 DB작업을 초기화시킴. 등록/수정/삭제시 필수
    @Transactional
    public long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    // readOnly 옵션을 주게되면 트랜잭션의 범위는 유지하지만 조회기능만 남기게되므로 조회속도가 개선된다.
    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                // lambda 식 .map(posts -> new PostsMainResponseDto(posts))과 같음.
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());

//         기본 제공 Entity로 DESC 목록 불러오기 (return Posts)
//        return postsRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC,"id")));
    }
}
