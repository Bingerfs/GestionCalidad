package Proyecte.ApplicationLogic.UseCases;

import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.ICDRRepository;
import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;
import Proyecte.ApplicationLogic.DTOMappers.CallRecordMapper;
import Proyecte.EnterpriseLogic.CallRecord;

import java.util.ArrayList;
import java.util.List;

public class CallRecordService implements CallRecordBoundaryIn {
    private ICDRRepository icdrRepository;
    private CallRecordMapper mapper;

     public CallRecordService(ICDRRepository icdrRepository) {
        this.icdrRepository = icdrRepository;
        mapper = new CallRecordMapper();
    }

    @Override
    public List<CallRecordDto> getAllCallRecords(){
        List<CallRecordDto> callRecords = new ArrayList<>();
        for(CallRecord callRecord :icdrRepository.getAllCallRecords())
            callRecords.add(mapper.transClient(callRecord));
        return callRecords;
    }

    @Override
    public void createCallRecord(CallRecordDto callRecord) {
        icdrRepository.addCallRecord(callRecord);
    }

    @Override
    public CallRecord findCallRecordById(int ci) {
        return icdrRepository.getCallRecordById(ci);
    }
}
