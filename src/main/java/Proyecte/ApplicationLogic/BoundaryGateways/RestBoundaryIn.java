package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;

import java.util.List;

public interface RestBoundaryIn {
    List<CallRecordDto> getCallRecordsByPhone(String phoneNumber);
}