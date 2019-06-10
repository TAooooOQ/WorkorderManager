package com.ash.workorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Created by Ash on 2019/6/9 10:51
 */
@SpringBootApplication
@ImportResource("META-INF/spring-shiro.xml")
public class WorkOrderApplication {
    public static void main(String[] args){
        SpringApplication.run(WorkOrderApplication.class, args);
    }
}
