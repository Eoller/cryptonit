package pl.eoller.cryptonit.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class LatestMonetInfo {

    private List<MonetInfo> monetInfoList = new ArrayList<>();

    @SuppressWarnings("unchecked")
    @JsonProperty("data")
    private void unpackNested(List<Map<String,Object>> data) {

        for (int i = 0; i < data.size(); i++) {
            MonetInfo monetInfo = new MonetInfo();

            monetInfo.setName((String)data.get(i).get("name"));
            monetInfo.setSymbol((String)data.get(i).get("symbol"));

            Map<String,Object> quote = (Map<String,Object>)data.get(i).get("quote");
            Map<String,Object> usd = (Map<String,Object>)quote.get("USD");

            monetInfo.setPriceInUSD((double)usd.get("price"));
            monetInfo.setChangePercent24h((double)usd.get("percent_change_24h"));
            monetInfo.setVolume((double)usd.get("volume_24h"));

            monetInfoList.add(monetInfo);
        }

    }

}
