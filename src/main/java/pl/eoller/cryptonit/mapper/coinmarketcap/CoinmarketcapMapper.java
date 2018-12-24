package pl.eoller.cryptonit.mapper.coinmarketcap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import pl.eoller.cryptonit.model.coinmarketcap.LatestMonetInfo;
import pl.eoller.cryptonit.model.coinmarketcap.MonetInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CoinmarketcapMapper {

    public static LatestMonetInfo mapToLatestMonetInfo(String sourceJson){
        LatestMonetInfo latestMonetInfo = new LatestMonetInfo();
        try {
            JsonNode monetInfoNode = new ObjectMapper().readTree(sourceJson);
            JsonNode monetInfoJsonList = monetInfoNode.get("data");
            if(monetInfoJsonList.isArray()){

                List<MonetInfo> monetInfoList = new ArrayList<>();

                for (JsonNode data : monetInfoJsonList) {
                    monetInfoList.add(createMonetInfo(data));
                }

                latestMonetInfo.setMonetInfoList(monetInfoList);
                return latestMonetInfo;
            }
        } catch (IOException e) {
            log.error("Cannot cast this json: " + sourceJson + "to LatestMonetInfo");
        }
        return latestMonetInfo;
    }

    private static MonetInfo createMonetInfo(JsonNode data) {
        MonetInfo monetInfo = new MonetInfo();

        monetInfo.setName(data.get("name").asText());
        monetInfo.setSymbol(data.get("symbol").asText());

        JsonNode quouteUsd  = data.get("quote").get("USD");

        monetInfo.setChangePercent24h(quouteUsd.get("percent_change_24h").asDouble());
        monetInfo.setPriceInUSD(quouteUsd.get("price").asDouble());
        monetInfo.setVolume(quouteUsd.get("volume_24h").asDouble());

        return monetInfo;
    }


}
