package me.hongren.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//作用于方法
@Target(ElementType.METHOD)
//运行时注解
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAop {
    //方法描述
    String value() default "";
}
