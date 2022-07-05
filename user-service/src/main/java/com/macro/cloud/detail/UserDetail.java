package com.macro.cloud.detail;

import org.springframework.stereotype.Component;

@Component
public class UserDetail implements UserInfo {
    @Override
    public void showUser() {
        System.out.println("I am peter!");
    }
}
