package Proyecte.InterfaceAdapters.Presenters;

import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryOut;
import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;

import java.util.HashMap;
import java.util.List;

public class CallRecordPresenter implements CallRecordBoundaryOut {

    @Override
    public HashMap<String, Object> onShowAllCallRecords(List<CallRecordDto> callRecords) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("callRecords", callRecords);
        return model;
    }

}
