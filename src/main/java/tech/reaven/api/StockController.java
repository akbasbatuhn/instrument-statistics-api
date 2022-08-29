package tech.reaven.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import tech.reaven.model.BaseData;
import tech.reaven.model.FundamentalData;
import tech.reaven.model.PriceInfo;
import tech.reaven.model.Stock;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reaven.service.StockService;

import java.util.List;

@Tag(name = "Stock", description = "Stock Operations")
@RequestMapping("/stock")
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/{isinCode}")
    @Operation(summary = "Get stock by ISIN Code", responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Stock.class))),
            @ApiResponse(description = "Stock not found", responseCode = "404",
                    content = @Content)
    })
    public ResponseEntity<Stock> getStock(@PathVariable String isinCode){
        return ResponseEntity.ok(stockService.find(isinCode));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> stocks = stockService.findAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

//    @GetMapping("/{isinCode}")
//    @Operation(summary = "Get stock by ISIN Code", responses = {
//            @ApiResponse(description = "Success", responseCode = "200",
//            content = @Content(mediaType = "application/json",
//            schema = @Schema(implementation = Stock.class))),
//            @ApiResponse(description = "Stock not found", responseCode = "404",
//            content = @Content)
//    })
//    public ResponseEntity<Stock> getStock(@PathVariable String isinCode){
//        return ResponseEntity.ok(stockService.find(isinCode));
//    }
//
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.GET, path = "/{isinCode}")
//    public ResponseEntity<List<Stock>> getAllStocks(@PathVariable String isinCode){
//        return new Stock("DE1234567890", "New stock",
//                new PriceInfo(), new BaseData(), new FundamentalData(),
//                "DENEME!'^^%&/()=");
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
}
