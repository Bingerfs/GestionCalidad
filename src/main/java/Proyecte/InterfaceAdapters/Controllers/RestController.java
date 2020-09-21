package Proyecte.InterfaceAdapters.Controllers;

import java.util.List;

import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;
import Proyecte.ApplicationLogic.BoundaryGateways.RestBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.RestBoundaryOut;
import spark.Request;
import spark.Response;
import spark.Route;

public class RestController {
    private RestBoundaryIn restBoundaryIn;
    private RestBoundaryOut restBoundaryOut;

    public RestController(RestBoundaryIn restBoundaryIn, RestBoundaryOut restBoundaryOut) {
        this.restBoundaryIn = restBoundaryIn;
        this.restBoundaryOut = restBoundaryOut;
    }

    public Route getRecordsByPhoneNumber = (Request request, Response response) -> {
        String phoneNumber = request.queryParams("phoneNumber");
        System.out.println(phoneNumber);
        List<CallRecordDto> data = restBoundaryIn.getCallRecordsByPhone(phoneNumber);
        return restBoundaryOut.onRestRetrieval(data);
    };
    
}