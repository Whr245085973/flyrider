package me.hongren.service;

import me.hongren.domain.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

public interface LogService {

    @Async
    void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log);
}
