package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;
import Proyecte.EnterpriseLogic.CallRecord;

import java.util.List;

public interface ICDRRepository {
    void addCallRecord(CallRecordDto callRecord);
    List<CallRecord> getAllCallRecords();
    CallRecord getCallRecordById(int id);
    List<CallRecord> getCallRecordsByPhoneNumber(String phoneNumber);
}