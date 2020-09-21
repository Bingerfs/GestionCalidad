package Proyecte.EnterpriseLogic;

public class NormalSchedulePrepago implements IRateCalculatorBySchedule{

	private float ratePerMinute = (float) 1.45 ;

    
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
