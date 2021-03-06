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
		BufferedReader br = new BufferedReader(new FileReader("mergeTestCases"));
		String line;
    	while((line = br.readLine()) != null)
    	{
    		String[] SplittedInput = line.split(" ");
    		Input.add(SplittedInput[0]);
    		ExpectedOutput.add(SplittedInput[1]);
    	}
    	
    	for(int i = 0 ; i < Input.size() ; i++)
		{
			String[] startEndPairsInput = Input.get(i).split(",");
    		String[] startEndPairsOutput = ExpectedOutput.get(i).split(",");
    		
    		Range testRange1 = new Range(Integer.parseInt(startEndPairsInput[0]) , Integer.parseInt(startEndPairsInput[1]));
    		Range testRange2 = new Range(Integer.parseInt(startEndPairsInput[2]) , Integer.parseInt(startEndPairsInput[3]));
    		
    		if(startEndPairsOutput.length == 2)
    			assertEquals( startEndPairsOutput[0] + "," + startEndPairsOutput[1] , testRange1.mergeRange(testRange2).toString());
    		else
    			assertEquals("null", testRange1.mergeRange(testRange2));
		}
		
	}
	
	@Test
	public void testSplitRange() throws IOException {
		
		ArrayList <String> Input = new ArrayList<String>();
		ArrayList <String> ExpectedOutput = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("splitTestCases"));
		String line;
    	while((line = br.readLine()) != null)
    	{
    		String[] SplittedInput = line.split(" ");
    		Input.add(SplittedInput[0]);
    		ExpectedOutput.add(SplittedInput[1]);
    	}
    	
    	for(int i = 0 ; i < Input.size() ; i++)
		{
			String[] startEndPairsInput = Input.get(i).split(",");
    		String[] startEndPairsOutput = ExpectedOutput.get(i).split(",");
    		
    		Range testRange1 = new Range(Integer.parseInt(startEndPairsInput[0]) , Integer.parseInt(startEndPairsInput[1]));
    		Range testRange2 = new Range(Integer.parseInt(startEndPairsInput[2]) , Integer.parseInt(startEndPairsInput[3]));
    	
    		if(startEndPairsOutput.length == 2)
    			assertEquals("[" + ExpectedOutput.get(i)+"]" , testRange1.splitRange(testRange2).toString());
//    		else
//    			assertEquals("null", testRange1.splitRange(testRange2));
		}
		
	}
	
	@Test
	public void testdoesRangeOverLap() throws IOException {
		
		ArrayList <String> Input = new ArrayList<String>();
		ArrayList <String> ExpectedOutput = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("RangeOverlap_TestCases"));
		String line;
    	while((line = br.readLine()) != null)
    	{
    		String[] SplittedInput = line.split(" ");
    		Input.add(SplittedInput[0]);
    		ExpectedOutput.add(SplittedInput[1]);
    	}
    	
    	for(int i = 0 ; i < Input.size() ; i++)
		{
			String[] startEndPairsInput = Input.get(i).split(",");
    		String[] startEndPairsOutput = ExpectedOutput.get(i).split(",");
    		
    		Range testRange1 = new Range(Integer.parseInt(startEndPairsInput[0]) , Integer.parseInt(startEndPairsInput[1]));
    		Range testRange2 = new Range(Integer.parseInt(startEndPairsInput[2]) , Integer.parseInt(startEndPairsInput[3]));
    		
    		
    			assertEquals(ExpectedOutput.get(i), Boolean.toString(testRange1.doesRangeOverLap(testRange2)));
    		
		}
		
	}

	@Test
	public void testdoesRangeLieInsideAnother() throws IOException {
		
		ArrayList <String> Input = new ArrayList<String>();
		ArrayList <String> ExpectedOutput = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("RangeLieInside_TestCases"));
		String line;
    	while((line = br.readLine()) != null)
    	{
    		String[] SplittedInput = line.split(" ");
    		Input.add(SplittedInput[0]);
    		ExpectedOutput.add(SplittedInput[1]);
    	}
    	
    	for(int i = 0 ; i < Input.size() ; i++)
		{
			String[] startEndPairsInput = Input.get(i).split(",");
    		String[] startEndPairsOutput = ExpectedOutput.get(i).split(",");
    		
    		Range testRange1 = new Range(Integer.parseInt(startEndPairsInput[0]) , Integer.parseInt(startEndPairsInput[1]));
    		Range testRange2 = new Range(Integer.parseInt(startEndPairsInput[2]) , Integer.parseInt(startEndPairsInput[3]));
    		
    		if(startEndPairsOutput.length == 2)
    			assertEquals("[" + startEndPairsOutput[0] + "," + startEndPairsOutput[1] + "]", Boolean.toString(testRange1.doesRangeLieInsideAnother(testRange2)));
//    		else
//    			assertEquals("null", testRange1.doesRangeLieInsideAnother(testRange2));
		}
		
	}
}

