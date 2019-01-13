package pl.eoller.cryptonit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

public abstract class DaoBase {

    @PersistenceContext
    protected EntityManager entityManager;

}
