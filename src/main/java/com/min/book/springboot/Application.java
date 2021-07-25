package com.min.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//스프링 부트의 자동 설정, bean 읽기와 생성을 모두 자동으로 설정. @SpringbootApplicaiton 이 있는 위치부터 설정을 일겅가기 때문에
//이 클래스느 항상 프로젝트 최상다에 있어야 함.


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행, Jar만으로 실행되게 됨. 내장 WAS 권장됨. 안전성. 높은 트래픽도 문제 없음.
    }
}
