package com.semotpan.custom.application.events.transactional.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@ToString
@Getter
@Entity
@Table(name = "post_log")
@NoArgsConstructor(access = PRIVATE)
public class PostLog {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private int id;

    @Column(name = "issued_on", nullable = false)
    private Instant issuedOn;

    @Column(name = "post_id", nullable = false)
    private Integer postId;

    public PostLog(Instant issuedOn, Integer postId) {
        this.issuedOn = issuedOn;
        this.postId = postId;
    }
}
