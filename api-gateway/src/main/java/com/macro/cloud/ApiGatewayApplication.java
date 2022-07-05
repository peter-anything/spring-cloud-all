package com.macro.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;

//@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Tom");
        Observable.from(names).map(name -> name);

//        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
