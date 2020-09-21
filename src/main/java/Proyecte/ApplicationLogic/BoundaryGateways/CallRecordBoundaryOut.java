package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;

import java.util.HashMap;
import java.util.List;

public interface CallRecordBoundaryOut {
    HashMap<String, Object> onShowAllCallRecords(List<CallRecordDto> callRecords);

}
