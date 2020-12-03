package com.codiyampa.service.infrastructure.web.resource;

import com.codiyampa.jooq.public_.tables.ErrorLog;
import com.codiyampa.service.application.LogService;
import com.codiyampa.service.infrastructure.web.model.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author: Codiyampa
 * @date: 02.12.2020
 */

@RestController
@RequestMapping("/logs")
class LogController {

    LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping(value ="/create", consumes = APPLICATION_JSON_VALUE)
    void createLog(@RequestBody LogDto logDto) {
        logService.createLog(logDto);
    }

    @GetMapping(value ="/errors", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LogDto> getErrorLogs() {
        return logService.getErrorLogs().stream()
                .map(errorLog -> new LogDto(
                        errorLog.getId(),
                        errorLog.getCreationDate(),
                        errorLog.getMessage()
                        )
                )
                .collect(Collectors.toList());
    }
}