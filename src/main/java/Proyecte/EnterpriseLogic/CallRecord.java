package Proyecte.EnterpriseLogic;

import Proyecte.InterfaceAdapters.GatewayImpl.File.FileAccountRepository;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileClientRepository;
import Proyecte.ApplicationLogic.BoundaryGateways.IAccountRepository;

public class CallRecord {
    public int id_callRecord;
    public String callerPhoneNumber;
    public String endPointPhoneNumber;
    public String date;
    public Integer startingCallTime;
    public Float callDuration;
    public Float callCost;
    public String savedDate;
    

    public CallRecord(){
        callCost = (float)0;
        date="";
        id_callRecord = 0;

    }

    

    public void calculateCost() {
        IAccountRepository accountRepository = new FileAccountRepository("Accounts.txt","Receivables.txt",new FileClientRepository("clientangos.txt"));
        Account account = accountRepository.getAccountByPhoneNumber(callerPhoneNumber);
        IRateCalculator calculator = RateCalculatorFactory.getRateCalculator(this, account);
        callCost = calculator.calculateRate();
    }

    @Override
    public String toString() {
        String record = "callerPhoneNumber: "+callerPhoneNumber+" endPointPhoneNumber= "+ endPointPhoneNumber + " startingCallTime= "+startingCallTime+
        " callDuration: "+callDuration+" callCost: "+callCost;
        return record;
    }

    public CallRecord(int id_callRecord, String callerPhoneNumber, String endPointPhoneNumber, String date,
            Integer startingCallTime, Float callDuration, Float callCost) {
        this.id_callRecord = id_callRecord;
        this.callerPhoneNumber = callerPhoneNumber;
        this.endPointPhoneNumber = endPointPhoneNumber;
        this.date = date;
        this.startingCallTime = startingCallTime;
        this.callDuration = callDuration;
        this.callCost = callCost;
    }

    public CallRecord(String callerPhoneNumber, String endPointPhoneNumber, String date, Integer startingCallTime,
            Float callDuration, Float callCost) {
        this.callerPhoneNumber = callerPhoneNumber;
        this.endPointPhoneNumber = endPointPhoneNumber;
        this.date = date;
        this.startingCallTime = startingCallTime;
        this.callDuration = callDuration;
        this.callCost = callCost;
    }


    public int getId_callRecord() {
        return id_callRecord;
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

    public String getCallerPhoneNumber() {
        return callerPhoneNumber;
    }

    public String getEndPointPhoneNumber() {
        return endPointPhoneNumber;
    }

    public String getSavedDate(){
        return savedDate;
    }
}