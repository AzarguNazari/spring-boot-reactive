package service.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.account.modal.Account;
import service.account.repository.AccountRepository;

import java.util.logging.Logger;

@RestController
public class AccountController {

    private static final Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    private AccountRepository repository;

    @GetMapping(value = "/accounts/customer/{customer}")
    public Mono<Account> findByCustomer(@PathVariable("customer") String customerId) {
        logger.info("findByCustomer: " + customerId);
        return repository.findById(customerId);
    }

    @GetMapping(value = "/accounts")
    public Flux<Account> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/account/{id}")
    public Mono<Account> findById(@PathVariable("id") Integer id) {
        return repository.findByNumber(id);
    }

    @PostMapping(value = "/accounts")
    public void create(@RequestBody Account account) {
        repository.save(account);
    }

}