package pl.eoller.cryptonit.dao.crudrepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.eoller.cryptonit.conf.TestDbConf;
import pl.eoller.cryptonit.dao.DaoBaseForTest;
import pl.eoller.cryptonit.dao.impl.CoinmarketcapDaoImpl;

import static org.junit.Assert.*;

@Transactional
@ContextConfiguration(classes = { TestDbConf.class, CoinMarCapDao.class})
public class CoinMarCapDaoTest extends DaoBaseForTest {

   /* @Autowired
    private CoinMarCapDao coinMarCapDao; //do not load context, do not know why

    @Test
    public void shouldGetById(){
        coinMarCapDao.findAll();
    }*/

}