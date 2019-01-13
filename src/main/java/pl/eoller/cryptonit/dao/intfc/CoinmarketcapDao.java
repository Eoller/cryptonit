package pl.eoller.cryptonit.dao.intfc;

import pl.eoller.cryptonit.entity.coinmarketcap.CoinmarketcapMonetInfo;

import java.util.List;

public interface CoinmarketcapDao {

    CoinmarketcapMonetInfo save(CoinmarketcapMonetInfo coinmarketcapMonetInfo);

    CoinmarketcapMonetInfo getById(int id);

    List<CoinmarketcapMonetInfo> getAll();

    void deleteById(List<Integer> asList);

    List<CoinmarketcapMonetInfo> getByIds(List<Integer> asList);
}
