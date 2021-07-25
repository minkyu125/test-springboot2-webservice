package com.min.book.springboot.web.dto;

import com.min.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 절대!! Entity 클래스를 Request/Response 클래스로 사용해서는 안된다. 이렇게 따로 만들어주어야!
 Entity는 함부로 건들면 안되는 DB Layer
 request와 response용 Dto는 자주 변경이 이뤄지는 View Layer
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
