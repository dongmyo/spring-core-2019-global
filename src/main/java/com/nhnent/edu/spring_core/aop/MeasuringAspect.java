package com.nhnent.edu.spring_core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Order(1)
public class MeasuringAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasuringAspect.class);


    /*
     * TODO : #2 포인트컷 표현식 변경
     */
    @Around("@annotation(com.nhnent.edu.spring_core.aop.Measure)")
    public Object logInsertLogPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            stopWatch.stop();
            LOGGER.debug("NotiLogDao.insertLog execution: {} ms", stopWatch.getLastTaskTimeMillis());
        }

        return result;
    }

}
