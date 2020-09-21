package Proyecte.EnterpriseLogic;

import java.util.HashMap;

public class FriendsReceivable implements Receivable {

    String friends;

    public FriendsReceivable(String friends) {
        this.friends = friends;
    }

    @Override
    public Float applyReceivable(Float cost, String endpointNumber) {
        if (friends.contains(endpointNumber))
            cost = (float) 0;
        return cost;
    }

    @Override
    public HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("friends", friends);
        return data;
    }
    
    
}