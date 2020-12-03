package com.codiyampa.service.repository;

import com.codiyampa.jooq.public_.tables.pojos.Account;
import com.codiyampa.service.infrastructure.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;

import java.time.LocalDateTime;

/**
 * @author: Codiyampa
 * @date: 03.12.2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testSaveAccount() {
        // given
        Account account = new Account();
        account.setCreationDate(LocalDateTime.now());
        account.setFirstName("Georg");
        account.setSecondName("Muster");
        account.setEmail("georg@muster.com");

        accountRepository.saveAccount(account);

        // when
        Account found = accountRepository.findAccountByEmail(account.getEmail());

        // then
        Assertions.assertThat(found.getFirstName()).isEqualTo(account.getFirstName());
        Assertions.assertThat(found.getSecondName()).isEqualTo(account.getSecondName());
    }
}