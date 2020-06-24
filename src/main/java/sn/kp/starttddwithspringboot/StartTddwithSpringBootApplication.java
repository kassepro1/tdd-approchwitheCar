package sn.kp.starttddwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StartTddwithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartTddwithSpringBootApplication.class, args);
    }

}
