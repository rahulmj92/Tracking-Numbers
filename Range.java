package rangeClass;
import java.util.ArrayList;

class Range {
	Integer startRange;
	Integer endRange;

	Range(Integer start, Integer end){
		startRange  = start;
		endRange = end;
	}
	
	Range(){
		startRange = 0;
		endRange = 2147483647;
	}
	
	public Range mergeRange(Range list2){
		
		Integer minRange = this.startRange;
		Integer maxRange = list2.endRange;
		if (this.startRange > list2.startRange){
			minRange = list2.startRange;
		}
		if (list2.endRange > this.endRange){
			maxRange = list2.endRange;
		}
		
		
		return new Range(minRange , maxRange);
	}
	
	public ArrayList<Range> splitRange(Range list){
		
		ArrayList<Range> splitList = new ArrayList();
		
		if (this.startRange < list.startRange && this.endRange > list.endRange){
			splitList.add(new Range(this.startRange , list.startRange -1));
			splitList.add(new Range(list.endRange + 1 , this.endRange));
		return splitList;
		
		} else if (this.startRange < list.startRange && this.endRange <= list.endRange){
			splitList.add(new Range(this.startRange , list.startRange -1));
			return splitList;
			
		} else if (this.startRange >= list.startRange && this.endRange > list.endRange)
		
			splitList.add(new Range(list.endRange + 1  , this.endRange));
			return splitList;
		}
		
	
	public boolean doesRangeOverLap(Range list){
		if(list.endRange >= this.startRange && list.endRange <= this.endRange){
			return true;
		}
		if(this.startRange <= list.startRange && list.startRange <= this.endRange){
			return true;
		}
		
		return false;
	}
	
	public boolean doesRangeLieInsideAnother(Range list){
		if(this.endRange > list.endRange && this.startRange < list.startRange){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return "[" + this.startRange + "," + this.endRange +"]";
	}
}


