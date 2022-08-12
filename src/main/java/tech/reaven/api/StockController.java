package tech.reaven.api;
import org.springframework.beans.factory.annotation.Autowired;
import tech.reaven.StockListInitializer;
import tech.reaven.model.Stock;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.reaven.service.StockService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Stock", description = "Stock Operations")
@RequestMapping("/stock")
public class StockController {
    private List<Stock> stockList = new ArrayList<Stock>();

    @Autowired
    private StockService stockService;


    @PostConstruct
    private void init(){
        StockListInitializer stockListInitializer = new StockListInitializer();
        stockList = stockListInitializer.InitializeStockList();
    }

    @GetMapping("/{stockISIN}")
    @Operation(summary = "Get stock by ISIN Code", responses = {
            @ApiResponse(description = "Success", responseCode = "200",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Stock.class))),
            @ApiResponse(description = "Stock not found", responseCode = "404",
            content = @Content)
    })
    public ResponseEntity<Stock> getStock(String isinCode){
        return ResponseEntity.ok(stockService.find(isinCode));
    }
}
