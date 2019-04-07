package db.concurrency;

import db.concurrency.service.RequestService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "db.concurrency")
@EnableJpaRepositories(basePackages = "db.concurrency")
@EntityScan(basePackages = "db.concurrency")
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new SpringApplicationBuilder(App.class)
                .properties("spring.config.name: sql-db")
                .build()
                .run(args);
        RequestService requestService = ctx.getBean(RequestService.class);
        requestService.update(1);
    }

}
