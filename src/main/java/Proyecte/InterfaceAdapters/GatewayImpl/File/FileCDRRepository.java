package Proyecte.InterfaceAdapters.GatewayImpl.File;

import Proyecte.ApplicationLogic.DTOMappers.CallRecordDto;
import Proyecte.EnterpriseLogic.CallRecord;
import Proyecte.ApplicationLogic.BoundaryGateways.ICDRRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileCDRRepository implements ICDRRepository {

    private String fileName;

    public FileCDRRepository() {

    }

    public FileCDRRepository(String fileName) {
        this.fileName = "src/main/java/Proyecte/FrameworksDrivers/FilePersistency/"+fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void addCallRecord(CallRecordDto callRecord) {
        try {

            // clientFile.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd:MM:yyyy:HH:mm");
            String line = callRecord.id_callRecord + ", " + callRecord.callerPhoneNumber + ", "
                    + callRecord.endPointPhoneNumber + ", " + callRecord.date + ", " + callRecord.startingCallTime
                    + ", " + callRecord.callDuration + ", " + callRecord.callCost + ", " + formatter.format(date);
            out.write(line);
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<CallRecord> getAllCallRecords() {
        List<CallRecord> callRecords = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str = "";
            while ((str = in.readLine()) != null) {
                String[] callRecordData = str.split(", ");
                CallRecord callRecord = new CallRecord(Integer.parseInt(callRecordData[0]), callRecordData[1],
                        callRecordData[2], callRecordData[3], Integer.parseInt(callRecordData[4]),
                        Float.parseFloat(callRecordData[5]), Float.parseFloat(callRecordData[6]));
                callRecord.savedDate = callRecordData[7];
                callRecords.add(callRecord);
                System.out.println("datos" + callRecord);
            }
            in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return callRecords;
    }

    @Override
    public CallRecord getCallRecordById(int id) {
        CallRecord callRecord = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str = "";
            while ((str = in.readLine()) != null) {
                String[] recordData = str.split(", ");
                if (id == Integer.parseInt(recordData[0])) {
                    callRecord = new CallRecord(Integer.parseInt(recordData[0]), recordData[1], recordData[2],
                            recordData[3], Integer.parseInt(recordData[4]), Float.parseFloat(recordData[5]),
                            Float.parseFloat(recordData[6]));
                    break;
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callRecord;
    }

    @Override
    public List<CallRecord> getCallRecordsByPhoneNumber(String phoneNumber) {
        List<CallRecord> callRecords = new ArrayList<>();
        CallRecord callRecord;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str = "";
            while ((str = in.readLine()) != null) {
                String[] recordData = str.split(", ");
                if (phoneNumber.equals(recordData[1])) {
                    callRecord = new CallRecord(Integer.parseInt(recordData[0]), recordData[1], recordData[2],
                            recordData[3], Integer.parseInt(recordData[4]), Float.parseFloat(recordData[5]),
                            Float.parseFloat(recordData[6]));
                    callRecords.add(callRecord);
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callRecords;
    }


    


}