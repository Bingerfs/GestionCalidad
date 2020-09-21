package Proyecte.ApplicationLogic;

import Proyecte.EnterpriseLogic.Client;

import java.util.ArrayList;
import java.util.List;

public class RepositoryClient {
    private List<Client> clients;

    RepositoryClient(){
        clients = new ArrayList<>();
    }

    void addClient(Client client){
        clients.add(client);
    }

}