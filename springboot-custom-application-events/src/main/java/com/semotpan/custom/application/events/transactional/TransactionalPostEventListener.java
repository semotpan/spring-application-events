package com.semotpan.custom.application.events.transactional;

import com.semotpan.custom.application.events.transactional.domain.PostLog;
import com.semotpan.custom.application.events.transactional.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@Slf4j
@Component
@RequiredArgsConstructor
class TransactionalPostEventListener {

    private final PostRepository postRepository;


    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(TransactionalPostCreatedEvent event) {
        log.info("--<< BEFORE_COMMIT {}", event);
        // do any stuff before commit
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void afterCompletion(TransactionalPostCreatedEvent event) {
        log.info("--<< AFTER_COMPLETION {}", event);
        // do any stuff after completion
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterRollback(TransactionalPostCreatedEvent event) {
        log.info("--<< AFTER_ROLLBACK {}", event);
        // do any stuff after rollback
    }

    @Transactional(REQUIRES_NEW) // previous transaction is committed and it requires new transaction
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT) // default phase
    public void afterCommit(TransactionalPostCreatedEvent event) {
        log.info("--<< AFTER_COMMIT {}", event);
        postRepository.append(new PostLog(event.issuedOn, event.postId));
    }
}
