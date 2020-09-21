package Proyecte.InterfaceAdapters.GatewayImpl.File;

import Proyecte.ApplicationLogic.DTOMappers.ClientDto;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.ApplicationLogic.BoundaryGateways.IClientRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.StringValue;

public class FileClientRepository implements IClientRepository {

    private String fileName;

    public FileClientRepository(String fileName) {
        this.fileName = "src/main/java/Proyecte/FrameworksDrivers/FilePersistency/"+fileName;
    }

    @Override
    public void createClient(ClientDto client) {
        try {

            // clientFile.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            String line = client.name + ", " + client.ci + ", " + client.address;
            out.write(line);
            out.newLine();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str = "";
            while ((str = in.readLine()) != null) {
                String[] clientData = str.split(", ");
                Client client = new Client(clientData[0], clientData[1], clientData[2]);
                clients.add(client);
            }
            in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return clients;
    }

    @Override
    public Client getClientByCi(String ci) {
        Client client = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str = "";
            while ((str = in.readLine()) != null) {
                String[] clientData = str.split(", ");
                if(ci.equals(clientData[1])){
                    client = new Client(clientData[0], clientData[1], clientData[2]);
                    break;
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }
    
    
}