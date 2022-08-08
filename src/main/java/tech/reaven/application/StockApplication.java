package tech.reaven.application;

import tech.reaven.api.StockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = StockController.class, basePackages = {
        "tech.reaven.config"
})
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class);
    }
}
