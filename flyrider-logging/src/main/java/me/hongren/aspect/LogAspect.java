package me.hongren.aspect;

import lombok.extern.slf4j.Slf4j;
import me.hongren.domain.Log;
import me.hongren.service.LogService;
import me.hongren.utils.RequestHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

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
        this.logService = logService;
    }


    /** 功能描述:
    配置切入点
    * @return: void
    * @Author: Tomy
    * @Date: 2019/12/27 22:14
    */
    @Pointcut("@annotation(me.hongren.aop.LogAop)")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result;
        currentTime = System.currentTimeMillis();
        result = joinPoint.proceed();
        Log log = new Log("INFO",System.currentTimeMillis() - currentTime);
        HttpServletRequest request = RequestHolder.getHttpServletRequest();

        return result;
    }

}
