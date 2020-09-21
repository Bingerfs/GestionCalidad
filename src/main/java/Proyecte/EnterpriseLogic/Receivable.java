package Proyecte.EnterpriseLogic;

import java.util.HashMap;

public interface Receivable {
    Float applyReceivable(Float cost, String endpointNumber);
    HashMap<String, Object> getData();
}