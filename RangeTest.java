import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class RangeTest {

	@Test
	public void testMergeRange() throws IOException {
		
		ArrayList <String> Input = new ArrayList<String>();
		ArrayList <String> ExpectedOutput = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rmaji\\workspace\\Tracking Number\\src\\mergeTestCases.txt"));
		String line;
    	while((line = br.readLine()) != null)
    	{
    		String[] SplittedInput = line.split(" ");
    		Input.add(SplittedInput[0]);
    		ExpectedOutput.add(SplittedInput[1]);
    		//System.out.println(line);
    	}
    	
    	for(int i = 0 ; i < Input.size() ; i++)
		{
			//System.out.println(getNextDistanceExpectedOutput.get(i) + "  " + odometerObj.getNextDistance(getNextDistanceInput.get(i)));
			//assertTrue(getNextDistanceExpectedOutput.get(i).equals(odometerObj.getNextDistance(getNextDistanceInput.get(i))));
    		String[] startEndPairsInput = Input.get(i).split(",");
    		String[] startEndPairsOutput = ExpectedOutput.get(i).split(",");
    		
    		Range testRange1 = new Range(Integer.parseInt(startEndPairsInput[0]) , Integer.parseInt(startEndPairsInput[1]));
    		Range testRange2 = new Range(Integer.parseInt(startEndPairsInput[2]) , Integer.parseInt(startEndPairsInput[3]));
    		//System.out.println("[" + startEndPairsOutput[0] + "," + startEndPairsOutput[1] + "]" + "    " + testRange1.mergeRange(testRange2).toString());
    		if(startEndPairsOutput.length == 2)
    			assertEquals("[" + startEndPairsOutput[0] + "," + startEndPairsOutput[1] + "]", testRange1.mergeRange(testRange2).toString());
    		else
    			assertEquals("null", testRange1.mergeRange(testRange2));
		}
		
	}

}
