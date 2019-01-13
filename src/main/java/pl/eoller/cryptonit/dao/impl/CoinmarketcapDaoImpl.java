package pl.eoller.cryptonit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.eoller.cryptonit.dao.DaoBase;
import pl.eoller.cryptonit.dao.intfc.CoinmarketcapDao;
import pl.eoller.cryptonit.entity.coinmarketcap.CoinmarketcapMonetInfo;

import java.util.List;

@Repository
@Transactional
public class CoinmarketcapDaoImpl extends DaoBase implements CoinmarketcapDao {

    @Override
    public CoinmarketcapMonetInfo save(CoinmarketcapMonetInfo coinmarketcapMonetInfo){
        entityManager.persist(coinmarketcapMonetInfo);
        entityManager.flush();

        return coinmarketcapMonetInfo;
    }

    @Override
    public CoinmarketcapMonetInfo getById(int id) {

        CoinmarketcapMonetInfo result = entityManager.find(CoinmarketcapMonetInfo.class, id);

        return result;
    }

    @Override
    public List<CoinmarketcapMonetInfo> getAll() {
        return entityManager
                .createQuery("Select info from " + CoinmarketcapMonetInfo.class.getSimpleName() + " info")
                .getResultList();
    }

    @Override
    public void deleteById(List<Integer> ids) {
        int isSuccessfull = entityManager
                .createQuery("delete from " + CoinmarketcapMonetInfo.class.getSimpleName()
                        + " where id in (:ids)")
                .setParameter("ids", ids)
                .executeUpdate();
    }

    @Override
    public List<CoinmarketcapMonetInfo> getByIds(List<Integer> ids) {
        return entityManager.createQuery("Select monetList from " + CoinmarketcapMonetInfo.class.getSimpleName()
                + " monetList where id in (:ids)")
                .setParameter("ids", ids)
                .getResultList();
    }

}
