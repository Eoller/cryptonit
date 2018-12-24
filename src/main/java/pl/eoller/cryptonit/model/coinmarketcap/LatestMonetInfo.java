package pl.eoller.cryptonit.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;


@Data
public class LatestMonetInfo {

    private List<MonetInfo> monetInfoList = new ArrayList<>();

}
