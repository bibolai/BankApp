package com.bibo.springmvc.bankapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.logging.Logger;

@Aspect
@Component
public class BankAppAspect {

	private Logger logger = Logger.getLogger(getClass().getName(), null);

    @Pointcut("execution(# com.bibo.springmvc.bankapp.controllers.*.*(..))")
     private void forControllersPackage() {}
    
    @Pointcut("execution(# com.bibo.springmvc.bankapp.service.*.*(..))")
    private void forServicePackage() {}
    
    @Pointcut("execution(# com.bibo.springmvc.bankapp.dao.*.*(..))")
    private void forDaoPackage() {}
}
