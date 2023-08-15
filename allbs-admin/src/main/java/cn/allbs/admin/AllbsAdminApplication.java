package cn.allbs.admin;

import cn.allbs.annotation.EnableAllbsSwagger3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAllbsSwagger3
@SpringBootApplication
public class AllbsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllbsAdminApplication.class, args);
    }

}
