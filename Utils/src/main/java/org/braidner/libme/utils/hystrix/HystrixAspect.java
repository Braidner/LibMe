package org.braidner.libme.utils.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 30/01/2016
 * Time: 20:44
 */
@Aspect
@Component
public class HystrixAspect {

    private static Logger logger = LoggerFactory.getLogger(HystrixAspect.class);

//    @Around("within(org.braidner.libme.*.service..*)")
    public Object hystrixServiceMonitor(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        HystrixCommand hystrixCommand = getHystrixCommand(aJoinPoint);
        return hystrixCommand.execute();
    }

    private HystrixCommand getHystrixCommand(final ProceedingJoinPoint aJoinPoint) {
        String serviceName = aJoinPoint.getSignature().getDeclaringType().getSimpleName();
        String theShortName = aJoinPoint.getSignature().toShortString();
        HystrixCommand.Setter theSetter =
                HystrixCommand.Setter.
                        withGroupKey(HystrixCommandGroupKey.Factory.asKey(serviceName))
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                .withExecutionTimeoutEnabled(false));
        theSetter = theSetter.andCommandKey(HystrixCommandKey.Factory.asKey(theShortName));
        return new HystrixCommand(theSetter) {
            @Override
            protected Object run() throws Exception {
                try {
                    return aJoinPoint.proceed();
                } catch (Exception e) {
                    throw e;
                } catch (Throwable e) {
                    throw new Exception(e);
                }
            }
        };
    }
}
