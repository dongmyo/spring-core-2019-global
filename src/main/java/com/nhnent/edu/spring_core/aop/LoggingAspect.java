package com.nhnent.edu.spring_core.aop;

import com.nhnent.edu.spring_core.domain.Member;
import com.querydsl.core.util.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(* getOrCreateMember(..))")
    public void log() {
        LOGGER.debug("getOrCreateMember method is called");
    }

    @AfterReturning(value = "execution(* com.nhnent.edu.spring_core.repository.NotiLogDao.insertLog(..))",
            returning = "logId")
    // TODO : #1 JoinPoint는 첫번째 argument여야 함.
    // TODO : #1 JoinPoint must be the first argument.
    public void logAfterInsertLog(JoinPoint joinPoint, int logId) {
        // TODO : #2 JoinPoint에서 parameter를 가져온다.
    	// TODO : #2 retrieve argument from the JoinPoint.
        Member member = retrieveArgument(joinPoint, Member.class, "member");
        LOGGER.debug("member={}, inserted log_id={}", member, logId);
    }

    public static <T> T retrieveArgument(JoinPoint joinPoint, Class<T> argType, String argName) {
        String[] keys = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] vals = joinPoint.getArgs();

        if (ArrayUtils.isEmpty(keys) || ArrayUtils.isEmpty(vals) || keys.length != vals.length) {
            return null;
        }

        for (int i = 0; i < vals.length; i++) {
            if (argName.equals(keys[i])) {
                return argType.cast(vals[i]);
            }
        }

        return null;
    }

}
