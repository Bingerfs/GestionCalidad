package Proyecte.ApplicationLogic.DTOMappers;

import Proyecte.EnterpriseLogic.CallRecord;

public class CallRecordMapper {
    public CallRecord transformCallRecord(CallRecordDto data){
        CallRecord callRecord = new CallRecord(data.id_callRecord, data.callerPhoneNumber, data.endPointPhoneNumber,data.date,data.startingCallTime,data.callDuration,data.callCost);
        callRecord.savedDate = data.savedDate;
        return callRecord;
    }

    public CallRecordDto transClient(CallRecord callRecord){
        return new CallRecordDto(callRecord.id_callRecord, callRecord.callerPhoneNumber, callRecord.endPointPhoneNumber,callRecord.date,callRecord.startingCallTime,callRecord.callDuration,callRecord.callCost, callRecord.savedDate);

    }
}
