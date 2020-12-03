package com.codiyampa.service.infrastructure.repository;

import com.codiyampa.jooq.public_.Tables;
import com.codiyampa.jooq.public_.tables.pojos.Account;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: Codiyampa
 * @date: 03.12.2020
 */

@Repository
public class AccountRepository {

    DSLContext dslContext;

    @Autowired
    public AccountRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public Account findAccountByEmail(String email) {
        return dslContext
                .selectFrom(Tables.ACCOUNT)
                .where(Tables.ACCOUNT.EMAIL.eq(email))
                .fetchOneInto(Account.class);
    }

    public void saveAccount(Account account) {
        dslContext
                .insertInto(
                        Tables.ACCOUNT,
                        Tables.ACCOUNT.CREATION_DATE,
                        Tables.ACCOUNT.FIRST_NAME,
                        Tables.ACCOUNT.SECOND_NAME,
                        Tables.ACCOUNT.EMAIL)
                .values(account.getCreationDate(),
                        account.getFirstName(),
                        account.getSecondName(),
                        account.getEmail())
                .execute();
    }
}