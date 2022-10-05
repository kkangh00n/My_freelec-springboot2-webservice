package com.jojoldu.book.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                 //Getter메소드 생성
@NoArgsConstructor      //롬복에서 제공, 기본 생성자 자동 추가
@Entity     //JPA에서 제공, 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity{

    @Id     //id -> pk(primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //pk 생성규칙
    private Long id;

    @Column(length = 500, nullable = false)     //테이블의 칼럼을 나타냄
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder        //빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;

    }
}