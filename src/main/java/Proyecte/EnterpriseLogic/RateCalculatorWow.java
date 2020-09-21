package Proyecte.EnterpriseLogic;
import java.util.List;

public class RateCalculatorWow implements IRateCalculator{
    Float ratePerMinute = (float) 0.99;
    Float duration;
    String endpointNumber;
    List<Receivable> receivables;

    public RateCalculatorWow(Float duration, List<Receivable> receivables, String endpointNumber){
        this.duration = duration;
        this.receivables = receivables;
        this.endpointNumber = endpointNumber;
    }

    
    @Override
	public Float calculateRate() {
     
    	Float totalRate = (float) 0;
        totalRate = duration * ratePerMinute;
        if(receivables !=null){
            for(Receivable receivable : receivables)
                totalRate = receivable.applyReceivable(totalRate, endpointNumber);
        } 
        return totalRate;
    }

    

}
