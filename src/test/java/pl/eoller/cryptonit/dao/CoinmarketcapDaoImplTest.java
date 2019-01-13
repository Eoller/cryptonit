package pl.eoller.cryptonit.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.eoller.cryptonit.conf.DBConf;
import pl.eoller.cryptonit.conf.TestDbConf;
import pl.eoller.cryptonit.dao.impl.CoinmarketcapDaoImpl;
import pl.eoller.cryptonit.dao.intfc.CoinmarketcapDao;
import pl.eoller.cryptonit.entity.coinmarketcap.CoinmarketcapMonetInfo;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
@ContextConfiguration(classes = { TestDbConf.class, CoinmarketcapDaoImpl.class})
public class CoinmarketcapDaoImplTest extends DaoBaseForTest{

    @Autowired
    CoinmarketcapDao coinmarketcapDao;

    @Before
    public void initTest(){
        CoinmarketcapMonetInfo coinmarketcapMonetInfo = new CoinmarketcapMonetInfo(
                "Bitcoin","BTC",240000000d,4.5d, 4335d);
        CoinmarketcapMonetInfo coinmarketcapMonetInfo1 = new CoinmarketcapMonetInfo(
                "Etherium","ETH",5000000d,11.8d, 363d);
        CoinmarketcapMonetInfo coinmarketcapMonetInfo2 = new CoinmarketcapMonetInfo(
                "XPR","XPR",2000d,-3.1d, 0.81d);
        coinmarketcapDao.save(coinmarketcapMonetInfo);
        coinmarketcapDao.save(coinmarketcapMonetInfo1);
        coinmarketcapDao.save(coinmarketcapMonetInfo2);
    }

    @Test
    public void shouldGetById() {
        CoinmarketcapMonetInfo result = coinmarketcapDao.getById(1);
        assertNotNull(result);
        assertEquals("Bitcoin", result.getName());
        assertEquals("BTC", result.getSymbol());
        assertTrue(result.getVolume() == 240000000d);
        assertTrue(result.getChangePercent24h() == 4.5d);
        assertTrue(result.getPriceInUSD() == 4335d);
    }

    @Test
    public void shouldGetAllCoinsData(){
        List<CoinmarketcapMonetInfo> result = coinmarketcapDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() == 3);
    }

    @Test
    public void shouldGetByIdList(){
        List<CoinmarketcapMonetInfo> result = coinmarketcapDao.getByIds(Arrays.asList(1, 2));
        assertNotNull(result);
        assertTrue(result.size() == 2);
        assertTrue(result.get(1).getName().equals("Etherium"));
    }

    @Test
    public void shouldDeleteAllDataFromDataBaseByIds(){
        coinmarketcapDao.deleteById(Arrays.asList(1,2,3));
        List<CoinmarketcapMonetInfo> all = coinmarketcapDao.getAll();
        assertTrue(all.isEmpty());
    }
}