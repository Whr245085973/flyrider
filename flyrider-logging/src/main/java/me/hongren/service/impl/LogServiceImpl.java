package me.hongren.service.impl;

import me.hongren.aop.LogAop;
import me.hongren.domain.Log;
import me.hongren.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @ClassName LogServiceImpl
 * @Description: TODO
 * @Author Tomy
 * @Date 2019/12/28
 * @Version V1.0
 **/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log) {
        //获取方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAop aopLogAop = method.getAnnotation(LogAop.class);

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";

        StringBuffer params = new StringBuffer("{");
        // 参数值
        Object[] argValues = joinPoint.getArgs();
        // 参数名称
        String[] argNames = signature.getParameterNames();
        if (argValues != null) {
            for (int i = 0;i < argValues.length; i++){
                params.append(" ").append(argNames[i]).append(": ").append(argValues[i]);
            }
        }
        //方法描述，写在每一个方法上注解上
        if (log != null){
            log.setDescription(aopLogAop.value());
        }
        assert log != null;
        log.setRequestIp(ip);


    }
}
