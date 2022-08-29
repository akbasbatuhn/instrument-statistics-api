package tech.reaven.application;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.reaven.api.StockController;
import tech.reaven.config.SwaggerConfig;
import tech.reaven.repository.StockRepository;
import tech.reaven.service.StockService;

import java.util.Arrays;

@EnableJpaRepositories(basePackages = {"tech.reaven.repository"})
@EntityScan("tech.reaven.model")
@ComponentScan(basePackageClasses = {
        StockController.class,
        StockService.class,
        StockRepository.class,
        SwaggerConfig.class
})
@SpringBootApplication
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class);
    }

}
