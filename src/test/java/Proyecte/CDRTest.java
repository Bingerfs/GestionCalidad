package Proyecte;

import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryOut;
import Proyecte.ApplicationLogic.BoundaryGateways.ICDRRepository;
import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;
import Proyecte.ApplicationLogic.DTOMappers.CallRecordMapper;
import Proyecte.ApplicationLogic.UseCases.CallRecordService;
import Proyecte.EnterpriseLogic.CallRecord;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileCDRRepository;
import Proyecte.InterfaceAdapters.Presenters.CallRecordPresenter;
import Proyecte.InterfaceAdapters.Utils.CRReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CDRTest {



   @Test
   public void callrecord(){
       CallRecord record = new CallRecord("60774491","79789705","1998",4,(float)60,(float)0);

       record.calculateCost();
       Float expected = (float)0.0;
       assertEquals(expected, record.callCost);
   }
    @Test
    public void callrecord_tostring(){
        CallRecord record = new CallRecord("60774491","79789705","1998",4,(float)60,(float)0);
       record.id_callRecord =1;
       record.callDuration = (float)60;
       record.callerPhoneNumber = "60774491";
       record.endPointPhoneNumber = "79789705";
       record.startingCallTime = 4;
        record.calculateCost();
        Float expected = (float)42.0;
        //String expectedstring=record.getCallerPhoneNumber();
        String date=record.getDate()+record.getId_callRecord();

        String expectedstring = "callerPhoneNumber: "+record.getCallerPhoneNumber()+" endPointPhoneNumber= "+ record.getEndPointPhoneNumber() + " startingCallTime= "+record.getStartingCallTime()+
                " callDuration: "+record.getCallDuration()+" callCost: "+record.getCallCost();
        assertEquals(expectedstring+date, record.toString()+date);
    }
    @Test
    public void callrecorddto(){

        CallRecordDto record1 = new CallRecordDto(2,"00000000","60774491","1988",4,(float)60,(float)42.0,"15:02");

       assertEquals("00000000", record1.callerPhoneNumber);


    }
    @Test
    public void callrecordMapperto_DTO(){


        CallRecordDto record1 = new CallRecordDto(2,"00000000","60774491","1988",4,(float)60,(float)42.0,"15:02");
        CallRecordMapper callRecordMapper=new CallRecordMapper();
        CallRecord callRecord=callRecordMapper.transformCallRecord(record1);
        assertEquals("00000000", callRecord.callerPhoneNumber);


    }
    @Test
    public void callrecordMapperto_CR(){


        CallRecordDto record1 = new CallRecordDto(2,"00000000","60774491","1988",4,(float)60,(float)42.0,"15:02");
        CallRecordMapper callRecordMapper=new CallRecordMapper();
        CallRecord callRecord=callRecordMapper.transformCallRecord(record1);

        CallRecordDto callRecordDto=callRecordMapper.transClient(callRecord);
        assertEquals("00000000", callRecordDto.callerPhoneNumber);


    }
    @Test
    public void callrecordPresenter(){
        CallRecordBoundaryOut callRecordBoundaryOut=new CallRecordPresenter();
        CallRecordMapper mapper = new CallRecordMapper();
        List<CallRecord>list=new ArrayList<>();
        List<CallRecordDto> dtos = new ArrayList<>();
        CallRecord record = new CallRecord();
        record.id_callRecord =1;
        record.callDuration = (float)60;
        record.callerPhoneNumber = "00000000";
        record.endPointPhoneNumber = "60774491";
        record.startingCallTime = 4;
        CallRecord record2 = new CallRecord();
        record.id_callRecord =2;
        record.callDuration = (float)60;
        record.callerPhoneNumber = "00000040";
        record.endPointPhoneNumber = "60774491";
        record.startingCallTime = 4;
        list.add(record2);
        for(CallRecord callRecord : list)
            dtos.add(mapper.transClient(callRecord));
        HashMap<String, Object> model = new HashMap<>();
        model.put("callRecords", dtos);
        assertEquals(model, callRecordBoundaryOut.onShowAllCallRecords(dtos));
    }
    @Test
    public void callrecordservice(){
        CallRecordBoundaryIn callRecordBoundaryIn=new CallRecordService(new FileCDRRepository("Records.txt"));

        List<CallRecordDto> getAllCallRecords;
            getAllCallRecords =callRecordBoundaryIn.getAllCallRecords();
            //callRecordBoundaryOut.showAllCallRecords(callRecords);
        CallRecordDto record1 = new CallRecordDto(2,"60774491","79789705","1988",4,(float)60,(float)42.0,"15:02");
        CallRecordMapper callRecordMapper=new CallRecordMapper();
        CallRecord callRecord=callRecordMapper.transformCallRecord(record1);
        callRecordBoundaryIn.createCallRecord(record1);
        CallRecordDto callRecordDto=callRecordMapper.transClient(callRecord);
        assertEquals(record1.callerPhoneNumber, callRecordBoundaryIn.findCallRecordById(2).callerPhoneNumber);


    }
    @Test
    public void cr_reader(){
        List<CallRecord>callRecordList=new ArrayList<>();
        CallRecord record1 = new CallRecord("00000","22222","1988-06-10",10,null,(float)0);
        record1.id_callRecord=1;
        CallRecord record2 = new CallRecord("00000","22222","1988-06-10",10,null,(float)0);
        record2.id_callRecord=2;
        CallRecord record3 = new CallRecord("00000","22222","1988-06-10",10,null,(float)0);
        record3.id_callRecord=3;
        CallRecord record4 = new CallRecord("00000","22222","1988-06-10",10,null,(float)0);
        record4.id_callRecord=4;
        CallRecord record5 = new CallRecord("50000","92222","1988-06-10",10,null,(float)0);
        record5.id_callRecord=5;
        callRecordList.add(record1);
        callRecordList.add(record2);
        callRecordList.add(record3);
        callRecordList.add(record4);
        callRecordList.add(record5);
        CRReader.filename="callrecordslist.txt";
        List<CallRecord>lis2= CRReader.readfilecdr();

        assertEquals(callRecordList.get(0).id_callRecord, lis2.get(0).id_callRecord);


    }
    @Test
    public void cr_reader_exc(){
        ICDRRepository icdrRepository=new FileCDRRepository();

        CRReader.filename="callrecordslist2.txt";
        List<Integer> listavacia = new ArrayList<>();
        //List<CallRecord>lis2=CRReader.readfilecdr();
        assertEquals(listavacia, CRReader.readfilecdr());
    }


    /*@Test
    public void cr_readercalccost(){

        //CRReader.filename="cr.txt";
        //List<CallRecord>callRecordList=new ArrayList<>();
        CRReader.filename="cdr.txt";
        List<CallRecord>callRecordList=CRReader.readfilecdr();

       // List<CallRecord>lis=new ArrayList<>();
       // callRecordList=CRReader.readfilecdr();
        //lis2=CRReader.callRecords;
        //CRReader.rateAllRecords();
        Float expect=(float)0.0;
        //Float expected = (float)42.0;

        assertEquals(1, callRecordList.get(0).id_callRecord);


    }*/


}
