package com.semotpan.custom.application.events.transactional;

import com.semotpan.custom.application.events.transactional.domain.Post;
import com.semotpan.custom.application.events.transactional.domain.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@RecordApplicationEvents
@TestPropertySource("classpath:/application-test.properties")
class TransactionalPostEventListenerTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationEvents applicationEvents;

    @Autowired
    EntityManager entityManager;

    @Test
    void publishing() {
        var post = new Post("Test Post 1", "Test Payload ");

        postRepository.add(post);


        var persistedPost = entityManager.createQuery("SELECT p FROM Post p", Post.class).getResultList().stream()
                .findFirst();

        assertThat(persistedPost).isPresent();

        assertThat(persistedPost.get())
                .extracting(
                        Post::getTitle,
                        Post::getPayload)
                .contains(
                        post.getTitle(),
                        post.getPayload()
                );

        assertThat(applicationEvents.stream(TransactionalPostCreatedEvent.class).findFirst().get())
                .extracting(
                        TransactionalPostCreatedEvent::getPostId,
                        TransactionalPostCreatedEvent::getTitle
                )
                .containsExactly(
                        persistedPost.get().getId(),
                        post.getTitle()
                );
    }

    @Test
    void publishingWithRollback() {
        assertThatExceptionOfType(InvalidDataAccessApiUsageException.class)
                .isThrownBy(() -> postRepository.addWithRollback(new Post("Test Post With Rollback", "Test Payload With Rollback")));
    }
}