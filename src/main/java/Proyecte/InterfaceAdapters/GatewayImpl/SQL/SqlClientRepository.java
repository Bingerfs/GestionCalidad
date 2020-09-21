package Proyecte.InterfaceAdapters.GatewayImpl.SQL;

import java.util.List;

import Proyecte.ApplicationLogic.DTOMappers.ClientDto;
import Proyecte.ApplicationLogic.DTOMappers.ClientMapper;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.ApplicationLogic.BoundaryGateways.IClientRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class SqlClientRepository implements IClientRepository {

    private SessionFactory factory;
    private ServiceRegistry serviceRegistry;
    private Configuration config;

    public SqlClientRepository() {
        config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Client.class);
        config.addResource("Client.hbm.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);

    }

    @Override
    public void createClient(ClientDto client) {
        Session session = factory.openSession();
        Transaction tx = null;
        ClientMapper clientMapper = new ClientMapper();
        try {
            tx = session.beginTransaction();
            Client clientO = clientMapper.transformClient(client);
            session.save(clientO);
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
    public List<Client> getAllClients() {
        Session session = factory.openSession();
        List<Client> clients = session.createQuery("From Client").list();
        session.close();
        return clients;
    }

    @Override
    public Client getClientByCi(String ci) {
        Session session = factory.openSession();
        Query q = session.createQuery("From Client where client_id="+ci);
        Client client= (Client)q.uniqueResult();
        session.close();
        return client;
    }

    
    
    
}