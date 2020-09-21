package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.ClientDto;

import java.util.HashMap;
import java.util.List;

public interface ClientBoundaryOut {
    HashMap<String, Object> showAllClients(List<ClientDto> clients);
}