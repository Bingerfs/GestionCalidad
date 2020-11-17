package Proyecte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import Proyecte.EnterpriseLogic.CallRecord;

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

        assertEquals( callRecord.callCost,callRecords.get(0).callCost );
    }
}
