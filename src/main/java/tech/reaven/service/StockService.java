package tech.reaven.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.reaven.model.Stock;
import tech.reaven.repository.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService {
    @Autowired
    private final StockRepository stockRepository;

    public List<Stock> findAllStocks(){
        return stockRepository.findAll();
    }


    public Stock find(String isinCode){
        Stock foundStock = stockRepository.findByISINCode(isinCode);
        if(foundStock != null)
            return foundStock;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock not found");
    }
}
