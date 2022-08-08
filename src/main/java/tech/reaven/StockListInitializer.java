package tech.reaven;

import tech.reaven.file.JsonReader;
import tech.reaven.model.Stock;

import java.io.IOException;
import java.util.List;

public class StockListInitializer {
    private JsonHandler jsonHandler = new JsonHandler();

    public List<Stock> InitializeStockList(){
        JsonReader fileReader = new JsonReader();
        try {
            String jsonFilePath = fileReader.ReadJson();
            jsonHandler.DeserializeJson(jsonFilePath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonHandler.ReturnStockList();
    }
}
