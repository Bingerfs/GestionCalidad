package Proyecte.EnterpriseLogic;

import java.util.HashMap;

public class ReceivableFactory {
    public static Receivable getReceivable(String type, HashMap<String, Object> data){
		  
	    if (type == "FriendsReceivable")
	      return new FriendsReceivable(data.get("friends").toString());
	    
	    return null;
	    
	  }
}