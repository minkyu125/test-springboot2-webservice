package com.min.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 모든 getter 만들어 줌.
@RequiredArgsConstructor //final 필드인 애들을 넣은 생성자 만들어 줌.
public class HelloResponseDto {

    private final String name;
    private final int amount;
    /*
    JPA : 개발자는 객체지향적으로 프로그래밍할 수 있게 하고 JPA가 관계형DB에 맞게 SQL을 대신 생성 실행해 줌. 개굿.
    JPA <- Hibernate <- Spring Data JPA
    Spring Data JPA 쓰는 이유
    - 구현체 교체의 용이성 좋음 : hibernate 같은 구현체 바꾸기 쉬움.
    - 저장소 교체의 용이성 좋음 : RDB -> Mongo DB 등으로 저장소 바꾸기 쉬움.

     */


}
