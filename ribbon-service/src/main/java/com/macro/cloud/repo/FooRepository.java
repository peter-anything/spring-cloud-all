package com.macro.cloud.repo;

import org.springframework.stereotype.Service;

@Service
public class FooRepository {
    public void  sayHello() {
        System.out.println("hello, world!");
    }
}
