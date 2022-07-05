package com.macro.cloud.service;

import com.macro.cloud.repo.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService {
    @Autowired
    FooRepository fooRepository;

    public void sayHello() {
        fooRepository.sayHello();
    }
}
