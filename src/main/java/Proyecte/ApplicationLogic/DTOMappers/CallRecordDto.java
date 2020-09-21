package Proyecte.ApplicationLogic.DTOMappers;

public class CallRecordDto {

    public final int id_callRecord;
    public final String callerPhoneNumber;
    public final String endPointPhoneNumber;
    public final  String date;
    public final  Integer startingCallTime;
    public final Float callDuration;
    public final Float callCost;
    public final String savedDate;

     public CallRecordDto(int id_callRecord, String callerPhoneNumber, String endPointPhoneNumber, String date, Integer startingCallTime, Float callDuration, Float callCost, String savedDate) {
        this.id_callRecord = id_callRecord;
        this.callerPhoneNumber = callerPhoneNumber;
        this.endPointPhoneNumber = endPointPhoneNumber;
        this.date = date;
        this.startingCallTime = startingCallTime;
        this.callDuration = callDuration;
        this.callCost = callCost;
        this.savedDate = savedDate;
    }

    public int getId_callRecord() {
        return id_callRecord;
    }

    public String getCallerPhoneNumber() {
        return callerPhoneNumber;
    }

    public String getEndPointPhoneNumber() {
        return endPointPhoneNumber;
    }

    public String getDate() {
        return date;
    }

    public Integer getStartingCallTime() {
        return startingCallTime;
    }

    public Float getCallDuration() {
        return callDuration;
    }

    public Float getCallCost() {
        return callCost;
    }

    public String getSavedDate() {
        return savedDate;
    }
    
}
