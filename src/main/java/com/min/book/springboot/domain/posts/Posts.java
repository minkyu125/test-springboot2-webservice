package com.min.book.springboot.domain.posts;

// 서비스 초기 구축 단계에서는 테이블 설계가 빈번하게 변경되는데 이때 롬복이 코드 변경량을 최소화시켜주기 때문에 적극적으로 사용됨.
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄.
// Entity 클래스에서는 절대 setter 메소드를 만들지 않는다. 값 변경이 필요하면 명확한 목적과 의도가 드러나는 메소드를 만들자.
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙 정의. 이 타입이 auto increment됨
    private Long id; // Long 타입의 auto incre를 PK로 추천. mysql의 bigint가 됨. 주민번호, 복합키 등은 유니크 키로 별도 추가하자.

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
