package Proyecte.InterfaceAdapters.Controllers;

import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryIn;
import Proyecte.InterfaceAdapters.Utils.Path;
import Proyecte.InterfaceAdapters.Utils.ViewUtil;
import spark.*;

public class ClientController {
    private ClientBoundaryIn clientBoundaryIn;

    public ClientController(ClientBoundaryIn clientBoundaryIn){
        this.clientBoundaryIn = clientBoundaryIn;
    }

    public Route getAllClients = (Request request, Response response) -> {
        return ViewUtil.render(request, clientBoundaryIn.getAllClients(), Path.Template.CLIENTS);
    };
}