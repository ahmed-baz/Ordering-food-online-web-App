package demo.web.app.senior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan({"net.web.app.senior"})
@EntityScan({"net.web.app.senior.dal"})
public class SeniorSpringBootWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeniorSpringBootWebAppApplication.class, args);
    }

}
