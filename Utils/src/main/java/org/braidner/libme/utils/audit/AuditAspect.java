package org.braidner.libme.utils.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 20:44
 */
@Aspect
@Component
public class AuditAspect {

    private static Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Around("within(org.braidner.libme.*.service..*)")
    public Object hystrixServiceMonitor(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        String auditString = Stream.of("AUDIT: Call service",  aJoinPoint.getSignature().toShortString())
                .collect(Collectors.joining(": "));
        logger.info(auditString);
        return aJoinPoint.proceed();
    }

}
