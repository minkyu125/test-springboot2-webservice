package com.min.book.springboot.service;

import com.min.book.springboot.domain.posts.Posts;
import com.min.book.springboot.domain.posts.PostsRepository;
import com.min.book.springboot.web.dto.PostsResponseDto;
import com.min.book.springboot.web.dto.PostsSaveRequestDto;
import com.min.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
 스프링에서 bean 주입받는 방식은 세가지.
 autowired setter 생성자
 auto가 제일 비권장, 생성자가 제일 권장되는 방식
 RequiredArgsConstructor 에서 final이 선언된 모든 필드를 인자값으로 하는 생성자를 이 롬복 어노테이션이 만들어 줌.

 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                // 이렇게 예외처리를 할 수 있구나. 좋네ㅋㅋ
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );

        /*
            지금 이 부분이 신기해야함.
            DB에 update를 날리는 코드가 없이 업데이트가 된다는 점.
            JPA의 영속성 컨텍스트라는 성질 때문으로
            트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 영속성 컨텍스트가 유지되어서
            이 상태의 변경분은 트랜잭션 끝나는 시점에 해당 테이블에 반영됨.
            Dirty Checking 더티 체킹이라고 부름.
            - 요즘은 이런식이 많네.
         */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );
        return new PostsResponseDto(entity);
    }
}
