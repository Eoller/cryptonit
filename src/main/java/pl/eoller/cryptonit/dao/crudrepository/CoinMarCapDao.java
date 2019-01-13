package pl.eoller.cryptonit.dao.crudrepository;

import org.springframework.data.repository.CrudRepository;
import pl.eoller.cryptonit.entity.coinmarketcap.CoinmarketcapMonetInfo;

public interface CoinMarCapDao extends CrudRepository<CoinmarketcapMonetInfo, Integer> {
}
