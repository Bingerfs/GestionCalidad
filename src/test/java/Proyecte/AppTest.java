package Proyecte;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import Proyecte.EnterpriseLogic.CallRecord;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void initializeCallRecordsTests()
    {
        List<CallRecord> callRecords = new ArrayList<>();
        CallRecord callRecord = new CallRecord();
        callRecord.callerPhoneNumber = "00000000";
        callRecord.callDuration = (float) 60;
        callRecord.startingCallTime = 12;
        callRecord.endPointPhoneNumber = "79789705";
        callRecords.add(callRecord);

        //callRecords =App.initializeCallRecords();
        assertEquals( callRecord.callCost,callRecords.get(0).callCost );
    }
}
