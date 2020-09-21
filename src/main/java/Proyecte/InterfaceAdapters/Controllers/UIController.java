package Proyecte.InterfaceAdapters.Controllers;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.ApplicationLogic.BoundaryGateways.ICDRRepository;
import Proyecte.InterfaceAdapters.Utils.Path;
import Proyecte.InterfaceAdapters.Utils.ViewUtil;
import spark.*;
import java.util.*;

public class UIController {
     ICDRRepository icdrRepository;
     List<Client> clientList;
     ViewUtil viewUtil;
    Path path;

    public  Route index=(Request request, Response response)->{
        HashMap<String, Object> model = new HashMap<>();
        model.put("callrecordslist",this.clientList);
        return ViewUtil.render(request,model,Path.Template.INDEX);
    };

}
