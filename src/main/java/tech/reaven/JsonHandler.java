package tech.reaven;

import org.json.JSONArray;
import org.json.JSONObject;
import tech.reaven.model.BaseData;
import tech.reaven.model.FundamentalData;
import tech.reaven.model.PriceInfo;
import tech.reaven.model.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    private List<Stock> stockObjectList = new ArrayList<Stock>();

    public void DeserializeJson(String jsonFilePath) {
        CreateStocks(jsonFilePath);
    }

    private void CreateStocks(String jsonFilePath) {
        JSONObject strJasonObject = new JSONObject(jsonFilePath);
        JSONArray jsonArray = strJasonObject.getJSONArray("stockInfo");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            stockObjectList.add(CreateAStock(jsonObject));
        }
    }

    private Stock CreateAStock(JSONObject jsonObject) {
        String stockName = GetStockName(jsonObject);
        PriceInfo priceInfo = CreatePriceInfoObject(jsonObject);
        BaseData baseData = CreateBaseDataObject(jsonObject);
        FundamentalData fundamentalData = CreateFundamentalDataObject(jsonObject);
        String stockPortrait = GetPortrait(jsonObject);

        return new Stock(stockName, priceInfo,
                baseData, fundamentalData, stockPortrait);
    }

    private String GetStockName(JSONObject jsonObject) {
        return jsonObject.optString("stockName", null);
    }

    private String GetPortrait(JSONObject jsonObject) {
        return jsonObject.optString("portrait", null);
    }

    private PriceInfo CreatePriceInfoObject(JSONObject jsonObject) {
        boolean hasPriceInfoAttr = jsonObject.has("priceInfo");
        if (hasPriceInfoAttr) {
            JSONObject priceInfo = jsonObject.getJSONObject("priceInfo");
            return InitializePriceInfoObject(priceInfo);
        }
        return InitializePriceInfoObject();
    }

    private BaseData CreateBaseDataObject(JSONObject jsonObject) {
        boolean hasBaseDataAttr = jsonObject.has("baseData");
        if (hasBaseDataAttr) {
            JSONObject baseData = jsonObject.getJSONObject("baseData");
            return InitializeBaseDataObject(baseData);
        }
        return InitializeBaseDataObject();
    }

    private FundamentalData CreateFundamentalDataObject(JSONObject jsonObject) {
        boolean hasFundamentalDataAttr = jsonObject.has("fundamentalData");
        if (hasFundamentalDataAttr) {
            JSONObject fundamentalData = jsonObject.getJSONObject("fundamentalData");
            return InitializeFundamentalDataObject(fundamentalData);
        }
        return InitializeFundamentalDataObject();
    }

    private PriceInfo InitializePriceInfoObject() {
        return new PriceInfo();
    }

    private PriceInfo InitializePriceInfoObject(JSONObject priceInfo) {
        String stockExchange = priceInfo.optString("stockExchange", null);
        String lastUpdate = priceInfo.optString("lastUpdate", null);
        BigDecimal bid = priceInfo.optBigDecimal("bid", null);
        int bidVolume = priceInfo.optInt("bidVolume", -1);
        BigDecimal offer = priceInfo.optBigDecimal("offer", null);
        int offerVolume = priceInfo.optInt("offerVolume", -1);
        String spreadPercentage = priceInfo.optString("spreadPercentage", null);
        BigDecimal lastTradePrice = priceInfo.optBigDecimal("lastTradePrice", null);
        float changePercentage = priceInfo.optFloat("changePercentage", -1f);
        String stand = priceInfo.optString("stand", null); // ISO Date
        BigDecimal opening = priceInfo.optBigDecimal("opening", null);
        BigDecimal previousClose = priceInfo.optBigDecimal("previousClosing", null);
        int tradedVolume = priceInfo.optInt("tradedVolume", -1);
        float tradedAmount = priceInfo.optFloat("tradedAmount", -1f);
        BigDecimal dailyHigh = priceInfo.optBigDecimal("dailyHigh", null);
        BigDecimal dailyLow = priceInfo.optBigDecimal("dailyLow", null);
        BigDecimal high52w = priceInfo.optBigDecimal("high52w", null);
        String high52wDate = priceInfo.optString("high52wDate", null);
        BigDecimal low52w = priceInfo.optBigDecimal("low52w", null);
        String low52wDate = priceInfo.optString("low52wDate", null);

        return new PriceInfo(stockExchange, lastUpdate,
                bid, bidVolume, offer, offerVolume,
                spreadPercentage, lastTradePrice, changePercentage,
                stand, opening, previousClose,
                tradedVolume, tradedAmount, dailyHigh, dailyLow,
                high52w, high52wDate, low52w, low52wDate);
    }

    private BaseData InitializeBaseDataObject() {
        return new BaseData();
    }

    private BaseData InitializeBaseDataObject(JSONObject baseData) {
        String securityType = baseData.optString("securityType", null);
        String stockISIN = baseData.optString("stockISIN", null);
        String stockWKN = baseData.optString("stockWKN", null);
        String currency = baseData.optString("currency", null);
        String initialListingDate = baseData.optString("initialListingDate", null);
        String foundingYear = baseData.optString("foundingYear", null);
        String fiscalDate = baseData.optString("fiscalDate", null);

        return new BaseData(securityType, stockISIN, stockWKN,
                currency, initialListingDate, foundingYear, fiscalDate);
    }

    private FundamentalData InitializeFundamentalDataObject() {
        return new FundamentalData();
    }

    private FundamentalData InitializeFundamentalDataObject(JSONObject fundamentalData) {
        String industry = fundamentalData.optString("industry", null);
        long marketCapital = fundamentalData.optLong("marketCapital", -1);
        int stockPieces = fundamentalData.optInt("pieces", -1);
        long equityCapital = fundamentalData.optLong("equityCapital", -1);
        int numberOfEmployees = fundamentalData.optInt("numberOfEmployees", -1);
        String lastGeneralMeeting = fundamentalData.optString("lastGeneralMeeting", null);

        return new FundamentalData(industry, marketCapital,
                stockPieces, equityCapital,
                numberOfEmployees, lastGeneralMeeting);
    }

    public List<Stock> ReturnStockList(){
        return stockObjectList;
    }
}
