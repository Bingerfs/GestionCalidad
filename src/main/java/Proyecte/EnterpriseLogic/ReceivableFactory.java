package Proyecte.EnterpriseLogic;

import java.util.HashMap;

public class ReceivableFactory {
	private ReceivableFactory() {
		throw new IllegalStateException("Factory class");
	  }
    public static Receivable getReceivable(String type, HashMap<String, Object> data){
		  
	    if (type.equals("FriendsReceivable"))
	      return new FriendsReceivable(data.get("friends").toString());
	    
	    return null;
	    
	  }
}