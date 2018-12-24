package pl.eoller.cryptonit.service;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class CoinmarketcapServiceTest {

    CoinmarketcapService coinmarketcapService = new CoinmarketcapService(new RestTemplate());

    @Test
    public void shouldHaveAuth(){
        coinmarketcapService.getAllCoinsInfo();
    }

}