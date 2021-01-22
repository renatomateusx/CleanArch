package com.renatomateusx.arch;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.renatomateusx.arch"})
@EntityScan({"com.renatomateusx.arch"})

public class Boot {
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
