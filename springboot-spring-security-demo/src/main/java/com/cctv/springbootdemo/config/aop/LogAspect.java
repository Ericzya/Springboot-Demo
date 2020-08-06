package com.cctv.springbootdemo.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: Eric
 * @Date: 2020/2/23 13:16
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.cctv.springbootdemo.web.*.*.*(..))")
    public void setControllerLog() {
    }

    @Pointcut("execution(public * com.cctv.springbootdemo.service.*.svc.*.*(..))")
    public void setServiceLog() {
    }

    @Before("setControllerLog()")
    public void printControllerLog(JoinPoint joinPoint) {
        logger.info("---------------------------Controller Log Begin---------------------------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            logger.error("RequestAttributes为空！");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            // 记录请求URL,Get/Post,IP,参数,方法等
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());
            logger.info("THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
            logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("---------------------------Controller Log End---------------------------");
        }
    }

    @Before("setServiceLog()")
    public void printServiceLog(JoinPoint joinPoint) {
        // 记录接口参数,方法等
        logger.info("---------------------------Service Log Begin---------------------------");
        logger.info("THE ARGS OF THE SERVICE : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("---------------------------Service Log End---------------------------");
    }

}
