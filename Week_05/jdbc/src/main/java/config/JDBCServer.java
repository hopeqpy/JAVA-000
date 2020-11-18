package config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@SpringBootApplication
@Slf4j
public class JDBCServer {

    public static void main(String[] args) {
        SpringApplication.run(JDBCServer.class, args);
        log.info("http://localhost:8082/user");
    }
}
