package Proyecte.ApplicationLogic.UseCases;

import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryOut;
import Proyecte.ApplicationLogic.BoundaryGateways.IClientRepository;
import Proyecte.ApplicationLogic.DTOMappers.ClientDto;
import Proyecte.ApplicationLogic.DTOMappers.ClientMapper;
import Proyecte.EnterpriseLogic.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientService implements ClientBoundaryIn {
    private IClientRepository clientRepository;
    private ClientBoundaryOut clientBoundaryOut;

    public ClientService(IClientRepository clientRepository, ClientBoundaryOut clientBoundaryOut){
        this.clientRepository = clientRepository;
        this.clientBoundaryOut = clientBoundaryOut;
    }

    @Override
    public void createClient(ClientDto client) {
        clientRepository.createClient(client);
    }

    @Override
    public HashMap<String, Object> getAllClients() {
        ClientMapper mapper = new ClientMapper();
        List<Client> clients =clientRepository.getAllClients();
        List<ClientDto> clientsDto = new ArrayList<>();
        for(Client client : clients)
            clientsDto.add(mapper.transClient(client));
        return clientBoundaryOut.showAllClients(clientsDto);
    }

    @Override
    public ClientDto findClientByCi(String ci){
        ClientMapper mapper = new ClientMapper();
        return mapper.transClient(clientRepository.getClientByCi(ci));
    }
    
    
}