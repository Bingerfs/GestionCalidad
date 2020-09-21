package Proyecte.EnterpriseLogic;

public class ReduceSchedulePrepago implements IRateCalculatorBySchedule{

	
	private float ratePerMinute = (float) 0.95 ;

    
	@Override
	public Float calculateRate() 
	{
		
		return ratePerMinute;
	}
	
	@Override
	public Float getRatePerMinute() {
		return ratePerMinute;
	}
}
