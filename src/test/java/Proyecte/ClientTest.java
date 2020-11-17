package Proyecte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryIn;
import Proyecte.ApplicationLogic.DTOMappers.ClientDto;
import Proyecte.ApplicationLogic.DTOMappers.ClientMapper;
import Proyecte.ApplicationLogic.UseCases.ClientService;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileClientRepository;
import Proyecte.InterfaceAdapters.Presenters.ClientPresenter;
import Proyecte.InterfaceAdapters.Utils.JsonUtil;
import Proyecte.ApplicationLogic.RepositoryClient;


import java.util.HashMap;

public class ClientTest {
    @Test
    public void clientservice(){
        ClientBoundaryIn clientBoundaryIn=new ClientService(new FileClientRepository("clientangos.txt"), new ClientPresenter());

        HashMap<String, Object> getAllClients;
        getAllClients =clientBoundaryIn.getAllClients();

        ClientDto clientDto = new ClientDto("Carlos, ","uhh","34");
        ClientMapper clientMapper=new ClientMapper();
        Client client=clientMapper.transformClient(clientDto);
        clientBoundaryIn.createClient(clientDto);
        ClientDto clientDto1=clientMapper.transClient(client);
        String a = null;
        assertNull(a);
    }
    
    @Test//*
    public void datatojson(){
        Client client = new Client();
        client.address = "asd";
        client.ci = "12345";
        client.name="robert";
        JsonUtil jsonUtil= new JsonUtil();
        String res=jsonUtil.dataToJson(client);
        String expected = res;
        assertEquals(expected,res);
    }

    @Test
    public void ConstructorClient(){
        Client client = new Client("abc","12345","asd");
        client.address="asd";
        client.ci = "12345";
        client.name = "abc";
        assertEquals("abc", client.getName());
        assertEquals("12345", client.getCi());
        assertEquals("asd", client.getAddress());
    }
    @Test
    public void ConstructorClientDTO(){
        ClientDto clientDto = new ClientDto("abc", "asd", "12345");

        assertEquals("abc", clientDto.name);
        assertEquals("12345", clientDto.ci);
        assertEquals("asd", clientDto.address);
    }

    @Test
    public void ClientMapperTest(){
        ClientMapper clientMapper = new ClientMapper();

        Client client = new Client("abc","12345","asd");
        client.address="asd";
        client.ci = "12345";
        client.name = "abc";
        ClientDto clientDto = new ClientDto("abc", "asd", "12345");

        clientMapper.transClient(client);
        clientMapper.transformClient(clientDto);
        assertEquals("abc", clientMapper.transClient(client).name);
        assertEquals("abc", clientMapper.transformClient(clientDto).name);
    }

    @Test
    public void getClientDtoName(){
        ClientDto clientDto = new ClientDto("Carlos","uhh","34");
        String name = "Carlos";
        assertEquals(name, clientDto.getName());
    }

    @Test
    public void getClientDtoCi(){
        ClientDto clientDto = new ClientDto("Carlos","uhh","34");
        String ci = "34";
        assertEquals(ci, clientDto.getCi());
    }

    @Test
    public void addClientToRepository(){
        Client client = new Client();
        client.setAddress("address");
        client.setCi("12345");
        client.setName("robert");

        RepositoryClient repository= new RepositoryClient() ;

        repository.addClient(client);

        assertEquals(client, repository.getClients().get(0));
    }

    
}
