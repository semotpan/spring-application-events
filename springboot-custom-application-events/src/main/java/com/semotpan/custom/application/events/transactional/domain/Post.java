package com.semotpan.custom.application.events.transactional.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@ToString
@Getter
@Entity
@NoArgsConstructor(access = PRIVATE)
@EqualsAndHashCode
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String payload;

    public Post(String title, String payload) {
        this.title = title;
        this.payload = payload;
    }
}
