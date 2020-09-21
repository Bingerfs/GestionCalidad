package Proyecte.InterfaceAdapters.Presenters;

import Proyecte.ApplicationLogic.BoundaryGateways.RestBoundaryOut;
import Proyecte.InterfaceAdapters.Utils.JsonUtil;

public class RestPresenter implements RestBoundaryOut {
    private JsonUtil json = new JsonUtil();
    @Override
    public Object onRestRetrieval(Object o) {
        return json.dataToJson(o);
    }
    
    
}