package com.codiyampa.service.service;

import com.codiyampa.jooq.public_.tables.pojos.Account;
import com.codiyampa.service.application.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: Codiyampa
 * @date: 03.12.2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    public void testCreateAccount() {
        // given
        Account account = new Account();
        account.setFirstName("Max");
        account.setSecondName("Muster");
        account.setEmail("max@muster.com");

        accountService.createAccount(account); // this method tests transactions

        // when
        Account found = accountService.findAccountByEmail(account.getEmail());

        // then
        Assertions.assertThat(found.getFirstName()).isEqualTo(account.getFirstName());
    }

    @Test
    public void testCreateTwoAccounts() {
        // given
        Account account = new Account();
        account.setFirstName("Lisa");
        account.setSecondName("Muster");
        account.setEmail("lisa@muster.com");

        try {
            accountService.createTwoAccounts(account); // this method makes two inserts
        } catch (Exception e) {
            // transaction rolled back
        }

        // when
        Account found = accountService.findAccountByEmail(account.getEmail());

        // then
        assertThat(found).isNull(); // transaction rolled back successfully
    }
}
