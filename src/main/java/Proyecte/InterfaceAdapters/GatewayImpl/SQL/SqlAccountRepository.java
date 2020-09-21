package Proyecte.InterfaceAdapters.GatewayImpl.SQL;
import Proyecte.EnterpriseLogic.Account;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.ApplicationLogic.BoundaryGateways.IAccountRepository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class SqlAccountRepository implements IAccountRepository {

    private SessionFactory factory;
    private ServiceRegistry serviceRegistry;
    private Configuration config;

    @Override
    public void createAccount(Account account) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(account);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public Account getAccountByPhoneNumber(String phoneNumber) {
        Session session = factory.openSession();
        Query q = session.createQuery("From Account where phone_number=" + phoneNumber);
        Account account = (Account) q.uniqueResult();
        session.close();
        return account;
    }

    public SqlAccountRepository() {
        config = new Configuration();
        config.configure("./hibernate.cfg.xml");
        config.addClass(Client.class);
        config.addClass(Account.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    @Override
    public List<Account> getAccounts() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}