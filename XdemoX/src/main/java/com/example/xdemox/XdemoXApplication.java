package main.java.com.example.xdemox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableCaching
@SpringBootApplication
@EnableScheduling
@EnableWebSocket
public class XdemoXApplication {

    public static void main(String[] args) {

        SpringApplication.run(XdemoXApplication.class, args);
    }

}
