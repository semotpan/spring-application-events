package com.semotpan.custom.application.events.transactional;

import com.semotpan.custom.application.events.EventPublisher;
import com.semotpan.custom.application.events.transactional.domain.Post;
import com.semotpan.custom.application.events.transactional.domain.PostLog;
import com.semotpan.custom.application.events.transactional.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
class JpaPostRepository implements PostRepository {

    private final EventPublisher publisher;
    private final EntityManager entityManager;

    @Transactional
    @Override
    public void add(Post post) {
        entityManager.persist(post);
        publisher.publish(new TransactionalPostCreatedEvent(post.getTitle(), post.getId()));
    }

    @Override
    public void append(PostLog postLog) {
        entityManager.persist(postLog);
    }

    @Transactional(rollbackOn = IllegalArgumentException.class)
    @Override
    public void addWithRollback(Post post) {
        publisher.publish(new TransactionalPostCreatedEvent(post.getTitle(), post.getId()));
        throw new IllegalArgumentException("Transaction failed");
    }
}
