package Proyecte.EnterpriseLogic;

public class PlanScheduleFactory {
	  public static IRateCalculatorBySchedule getPlanSchedule(Integer startingCallTime){
		  
	    if (startingCallTime >= 07 && startingCallTime < 21 )
	      return new NormalSchedulePrepago();
	    
	    if (startingCallTime >= 21 || startingCallTime < 01 )
	      return new ReduceSchedulePrepago();
	    
	    if (startingCallTime >= 01 && startingCallTime < 07 )
	      return new SuperReduceSchedulePrepago();
	    return null;
	    
	  }

}
