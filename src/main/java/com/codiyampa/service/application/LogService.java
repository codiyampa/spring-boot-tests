package com.codiyampa.service.application;

import com.codiyampa.jooq.public_.tables.records.ErrorLogRecord;
import com.codiyampa.service.infrastructure.repository.LogRepository;
import com.codiyampa.service.infrastructure.web.model.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Codiyampa
 * @date: 02.12.2020
 */

@Service
public class LogService {

    LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void createLog(LogDto logDto) {
        if (logDto.getMessage().contains("error")) {
            logRepository.saveErrorLog(logDto);
        }
    }

    public List<ErrorLogRecord> getErrorLogs() {
        return logRepository.getErrorLogs();
    }
}
