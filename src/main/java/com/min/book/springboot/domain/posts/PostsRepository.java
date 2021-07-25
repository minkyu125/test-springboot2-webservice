package com.min.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 생성후 jpaRepository<entity 클래스, PK 타입> 상속하면 기본 CRUD 메소드가 자동 생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {
    
}
