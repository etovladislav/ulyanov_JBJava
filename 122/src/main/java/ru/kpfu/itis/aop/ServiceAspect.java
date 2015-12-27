package ru.kpfu.itis.aop;


import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ServiceAspect {


    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start invoking "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params "
                + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("End invoking method: " + (end - start) + "ms");
        return result;
    }

    public Object error(ProceedingJoinPoint joinPoint) throws Throwable {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                System.out.println("Error: "+throwable.toString()+" " +
                        "args"+joinPoint.getArgs());
            }
        return joinPoint.proceed();
    }

}
