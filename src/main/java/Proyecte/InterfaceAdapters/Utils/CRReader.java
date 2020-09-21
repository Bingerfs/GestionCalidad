package Proyecte.InterfaceAdapters.Utils;

import Proyecte.EnterpriseLogic.CallRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public  class CRReader {
     public static String filename;
     public static List<CallRecord> callRecords;

     public static List<CallRecord>readfilecdr(){
         callRecords = new ArrayList<>();
         try {
             BufferedReader in = new BufferedReader(new FileReader("./storage/"+filename));
             String str = "";
             while ((str = in.readLine()) != null) {
                 String[] callRecordData = str.split(", ");
                 CallRecord callRecord = new CallRecord( Integer.parseInt(callRecordData[0]), callRecordData[1], callRecordData[2], callRecordData[3], Integer.parseInt(callRecordData[4]), Float.parseFloat(callRecordData[5]), Float.parseFloat(callRecordData[6]));
                 callRecords.add(callRecord);
                 System.out.println("datos"+callRecord);
             }
             in.close();
         } catch (Exception e) {
             //TODO: handle exception
         }
         return callRecords;
     }

     public static void rateAllRecords(){
         for(int i =0; i<callRecords.size(); i++)
             callRecords.get(i).calculateCost();
     }

}
