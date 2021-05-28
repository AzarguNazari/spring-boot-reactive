package service.account.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.account.modal.Account;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, String> {

    Flux<Account> findAllByValue(String value);
    Mono<Account> findFirstByOwner(Mono<String> owner);
    Mono<Account> findByNumber(int accountNUmber);
}