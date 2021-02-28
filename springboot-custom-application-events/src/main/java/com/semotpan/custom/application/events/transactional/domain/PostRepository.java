package com.semotpan.custom.application.events.transactional.domain;

public interface PostRepository {

    void add(Post post);

    void append(PostLog postLog);

    void addWithRollback(Post post);
}
