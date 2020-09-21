package Proyecte.InterfaceAdapters.Presenters;

import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryOut;
import Proyecte.ApplicationLogic.DTOMappers.ClientDto;
import Proyecte.ApplicationLogic.DTOMappers.ClientMapper;

import java.util.HashMap;
import java.util.List;

public class ClientPresenter implements ClientBoundaryOut {

    @Override
    public HashMap<String, Object> showAllClients(List<ClientDto> clients) {
        ClientMapper mapper =  new ClientMapper();
        HashMap<String, Object> model = new HashMap<>();
        model.put("clients", clients);
        return model;
    }
    
}