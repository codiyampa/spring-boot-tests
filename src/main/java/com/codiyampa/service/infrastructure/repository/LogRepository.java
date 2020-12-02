package com.codiyampa.service.infrastructure.repository;

import com.codiyampa.jooq.public_.tables.ErrorLog;
import com.codiyampa.jooq.public_.tables.records.ErrorLogRecord;
import com.codiyampa.service.infrastructure.web.model.LogDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    public List<ErrorLogRecord> getErrorLogs(){
        return dslContext
                .selectFrom(ErrorLog.ERROR_LOG)
                .limit(10)
                .fetch();
    }

    public void saveErrorLog(LogDto logDto){
        dslContext
                .insertInto(ErrorLog.ERROR_LOG, ErrorLog.ERROR_LOG.CREATION_DATE, ErrorLog.ERROR_LOG.MESSAGE)
                .values(LocalDateTime.now(), logDto.getMessage())
                .execute();
    }
}
