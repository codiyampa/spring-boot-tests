package com.codiyampa.service.application;

import com.codiyampa.jooq.public_.tables.pojos.Account;
import com.codiyampa.service.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author: Codiyampa
 * @date: 03.12.2020
 */

@Service
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void createAccount(Account account) {
        account.setCreationDate(LocalDateTime.now());
        accountRepository.saveAccount(account);
    }

    @Transactional
    // Testing if the first insert is rolled back
    public void createTwoAccounts(Account account) {
        for (int i = 0; i < 2; i++) {
            account.setCreationDate(LocalDateTime.now());
            accountRepository.saveAccount(account);
        }
    }

    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }
}