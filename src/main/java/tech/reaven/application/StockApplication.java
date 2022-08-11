package tech.reaven.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.reaven.StockListInitializer;
import tech.reaven.api.StockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tech.reaven.model.Stock;
import tech.reaven.repository.StockRepository;
import tech.reaven.service.StockService;

import java.util.List;

@EnableJpaRepositories(basePackages = {"tech.reaven.repository"})
@EntityScan("tech.reaven.model")
@SpringBootApplication(scanBasePackages = {
        "tech.reaven.config",
        "tech.reaven.service",
        "tech.reaven.repository",
        "tech.reaven.api"
})
@ComponentScan(basePackageClasses = {
        StockController.class,
        StockService.class,
        StockRepository.class
})
public class StockApplication {
    private List<Stock> stockList;

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(StockService stockService){
        StockListInitializer stockListInitializer = new StockListInitializer();
        stockList = stockListInitializer.InitializeStockList();
        return args -> stockService.updateAllStocks(stockList);
    }
}
