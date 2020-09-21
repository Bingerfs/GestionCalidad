package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.ClientDto;

import java.util.HashMap;

public interface ClientBoundaryIn {
    HashMap<String, Object> getAllClients();
    void createClient(ClientDto client);
    ClientDto findClientByCi(String ci);
}