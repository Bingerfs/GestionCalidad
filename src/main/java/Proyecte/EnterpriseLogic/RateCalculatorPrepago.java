package Proyecte.EnterpriseLogic;

import java.util.List;

public class RateCalculatorPrepago implements IRateCalculator{
	
	
	
    private float ratePerMinute;
    private float totalRate;
    private float duration;
    private IRateCalculatorBySchedule schedule;
    private List<Receivable> receivables;
    private String endpointNumber;

    public RateCalculatorPrepago( float duration, IRateCalculatorBySchedule schedule, List<Receivable> receivables, String endpointNumber) {
      
        this.ratePerMinute = (float)0;
        this.duration = duration;
        this.totalRate = 0;
        this.schedule = schedule;
        this.receivables = receivables;
        this.endpointNumber = endpointNumber;
    }

    @Override
    public Float calculateRate() {
        totalRate = (float)0;
		IRateCalculatorBySchedule iRateCalculatorBySchedule = schedule;
        ratePerMinute = iRateCalculatorBySchedule.getRatePerMinute();
        totalRate = duration*ratePerMinute;
        if(receivables !=null){
            for(Receivable receivable : receivables)
                totalRate = receivable.applyReceivable(totalRate, endpointNumber);
        } 
        return totalRate;
    }
    

	
	
	
	  	

	    
	
	
	

}
