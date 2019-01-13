package pl.eoller.cryptonit.model.coinmarketcap;

import lombok.Data;


@Data
public class MonetInfo {

    private String name;
    private String symbol;
    private double changePercent24h;
    private double priceInUSD;
    private double volume;

}
