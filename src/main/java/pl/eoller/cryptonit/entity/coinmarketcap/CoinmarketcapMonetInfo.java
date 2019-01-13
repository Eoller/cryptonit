package pl.eoller.cryptonit.entity.coinmarketcap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "coinmarketcapmonetinfo")
@NoArgsConstructor
@Getter
@Setter
public class CoinmarketcapMonetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String symbol;
    private double volume;

    @Column(name = "change_percent_24h")
    private double changePercent24h;

    @Column(name = "price_usd")
    private double priceInUSD;

    public CoinmarketcapMonetInfo(String name, String symbol, double volume, double changePercent24h, double priceInUSD) {
        this.name = name;
        this.symbol = symbol;
        this.volume = volume;
        this.changePercent24h = changePercent24h;
        this.priceInUSD = priceInUSD;
    }
}
