package pl.eoller.cryptonit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.eoller.cryptonit.model.coinmarketcap.LatestMonetInfo;
import pl.eoller.cryptonit.model.coinmarketcap.MonetInfo;
import pl.eoller.cryptonit.util.URLs;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
@Slf4j
public class CoinmarketcapService {

    private RestTemplate restTemplate;

    public List<MonetInfo> getAllCoinsInfo() {
        HttpEntity<String> entity = new HttpEntity<>("parameters", getHeadersWithAuth());

        ResponseEntity<String> result = restTemplate
                .exchange(URLs.COIN_MARKET_CAP_API + "/v1/cryptocurrency/listings/latest", GET, entity, String.class);

        LatestMonetInfo latestMonetInfo = null;
        try {
            latestMonetInfo = new ObjectMapper().readerFor(LatestMonetInfo.class).readValue(result.getBody());
        } catch (IOException e) {
            log.error("Cannot convert to JSON " + e.getMessage());
        }
        return latestMonetInfo.getMonetInfoList();
    }







    public CoinmarketcapService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private HttpHeaders getHeadersWithAuth(){
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-CMC_PRO_API_KEY","e1012d2e-b070-4cc8-8616-1789bdc4e229");

        return httpHeaders;
    }

}
