package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;
import Proyecte.EnterpriseLogic.CallRecord;

import java.util.List;

public interface CallRecordBoundaryIn {
    List<CallRecordDto> getAllCallRecords();
    void createCallRecord(CallRecordDto callRecord);
    CallRecord findCallRecordById(int ci);
}
