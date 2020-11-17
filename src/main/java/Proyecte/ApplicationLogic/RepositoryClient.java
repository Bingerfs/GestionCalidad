package Proyecte.ApplicationLogic;

import Proyecte.EnterpriseLogic.Client;

import java.util.ArrayList;
import java.util.List;

public class RepositoryClient {
    private List<Client> clients;

    public RepositoryClient(){
        clients = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public List<Client> getClients(){
        return clients;
    }

}