package com.macro.cloud.log;

import org.aspectj.lang.annotation.*;

@Aspect
public class LogInfo {
    @Pointcut("execution(* com.macro.cloud.detail.UserDetail.showUser(..))")
    public void perform() {
    }

    @Before("execution(* com.macro.cloud.detail.UserDetail.showUser(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

//    @Before("execution(* com.macro.cloud.detail.UserDetail.showUser(..))")
//    public void silenceCellPhones() {
//        System.out.println("Silencing cell phones");
//    }

    @After("execution(* com.macro.cloud.detail.UserDetail.showUser(..))")
    public void finish() {
        System.out.println("perform finish");
    }

    @AfterReturning("execution(* com.macro.cloud.detail.UserDetail.showUser(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* com.macro.cloud.detail.UserDetail.showUser(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
