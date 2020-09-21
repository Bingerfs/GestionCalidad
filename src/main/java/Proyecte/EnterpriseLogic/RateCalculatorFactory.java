package Proyecte.EnterpriseLogic;

public class RateCalculatorFactory {
	
	public static IRateCalculator getRateCalculator(CallRecord callRecord, Account account){
		
		IRateCalculator calculator = null;
		if(account.accoundType.equals("Prepago"))
			calculator = new RateCalculatorPrepago(callRecord.callDuration, PlanScheduleFactory.getPlanSchedule(callRecord.startingCallTime), account.receivables, callRecord.endPointPhoneNumber);
		
	    if(account.accoundType.equals("Postpago"))
	        calculator = new RateCalculatorPostpago(callRecord.callDuration, account.receivables, callRecord.endPointPhoneNumber);
	    
	    if(account.accoundType.equals("Wow"))
	        calculator = new RateCalculatorWow(callRecord.callDuration, account.receivables, callRecord.endPointPhoneNumber);
	    
	    return calculator;
	}

}
