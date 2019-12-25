package me.hongren.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/12/25 10:12
 **/
@Component
@Aspect
@Slf4j
public class LogAspect {

    private final LogService logService;

    private long currentTime =0L;

    public LogAspect(LogService logService) {
        @Pointcut("@annotation()")
        public void logPointcut() {

        }

    }

}
