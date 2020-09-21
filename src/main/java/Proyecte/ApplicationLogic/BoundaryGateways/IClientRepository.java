package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.ClientDto;
import Proyecte.EnterpriseLogic.Client;

import java.util.List;

public interface IClientRepository {
    List<Client> getAllClients();
    void createClient(ClientDto client);
    Client getClientByCi(String ci);
    
}