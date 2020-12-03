package com.codiyampa.service.infrastructure.repository;

import com.codiyampa.jooq.public_.Tables;
import com.codiyampa.jooq.public_.tables.pojos.ErrorLog;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Codiyampa
 * @date: 02.12.2020
 */

@Repository
public class LogRepository {

    DSLContext dslContext;

    @Autowired
    public LogRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<ErrorLog> getErrorLogs() {
        return dslContext
                .selectFrom(Tables.ERROR_LOG)
                .limit(10)
                .fetchInto(ErrorLog.class);
    }

    public void saveErrorLog(ErrorLog errorLog) {
        dslContext
                .insertInto(Tables.ERROR_LOG, Tables.ERROR_LOG.CREATION_DATE, Tables.ERROR_LOG.MESSAGE)
                .values(errorLog.getCreationDate(), errorLog.getMessage())
                .execute();
    }
}
