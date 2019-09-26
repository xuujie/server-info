package com.xujie.system.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SystemInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemInfoApplication.class, args);
    }

}
