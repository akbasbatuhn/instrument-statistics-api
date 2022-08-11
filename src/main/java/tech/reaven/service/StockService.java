package tech.reaven.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reaven.model.Stock;
import tech.reaven.repository.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> updateAllStocks(List<Stock> stockList){
        List<Stock> tempList = stockRepository.findAll();
        if(tempList.size() == 0){
            save(stockList);
        }
        else{
            for(Stock stock : tempList){
                for (Stock tempStock : stockList){
                    if (!stock.getStockName().equals(tempStock.getStockName())){
                        save(stock);
                    }
                }
            }
        }
        return tempList;
    }

    public Stock save(Stock stock){
        return stockRepository.save(stock);
    }

    public Iterable<Stock> save(List<Stock> stockList){
        return stockRepository.saveAll(stockList);
    }
}