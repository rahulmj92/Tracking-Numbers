import java.util.*;

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
		if(!doesRangeOverLap(list2)){
			return null;
		}
		if (this.startRange > list2.startRange){
			minRange = list2.startRange;
		}
		if (list2.endRange > this.endRange){
			maxRange = list2.endRange;
		}
		
		
		return new Range(minRange , maxRange);
	}
	
	public ArrayList<Range> splitRange(Range list){
		
		ArrayList<Range> splitList = new ArrayList<Range>();
		if (!doesRangeOverLap(list)){
			return null;
		}
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


public class Tracking {
	Range range;
	char statusCode;
	int transferCode;
	
	Tracking(){
		range = new Range(0, 1000000);
		this.statusCode = 'A';
		this.transferCode = 1;
	}
	
	Tracking(int rangeStartValue, int rangeEndValue, char status, int transfer) {
		range = new Range(rangeStartValue, rangeEndValue);
		statusCode = status;
		transferCode = transfer;
	}
	
	public String toString(){
		return ""+ range.toString()+","+ statusCode+","+transferCode;
	}
	
	public static List<Tracking> compareStatus(Tracking t1, Tracking t2){
		List<Tracking> temp = new ArrayList<Tracking>();
		if(t1.statusCode == t2.statusCode && t1.transferCode == t2.transferCode){
			Range mergedRange = t1.range.mergeRange(t2.range);
			Tracking mergedTrackingList = new Tracking(mergedRange.startRange, mergedRange.endRange , t2.statusCode , t2.transferCode);
			temp.add(mergedTrackingList);
		}
		else{
			if(t2.range.doesRangeOverLap(t1.range)){
				ArrayList<Range> r = t1.range.splitRange(t2.range);
				for(Range i : r){
					Tracking t = new Tracking();
					t.range = i;
					t.statusCode = t1.statusCode;
					t.transferCode = t1.transferCode;
					temp.add(t);
				}
				temp.add(t2);
			}
		}
		return temp;
	}
	public static List<Tracking> updateStatus(List<Tracking> t1){
		List<Tracking> trackingNew = new ArrayList<Tracking>();
		trackingNew.add(t1.get(0));
		for(int i=1; i < t1.size(); i++){
			List<Tracking> newTrackingList = new ArrayList<Tracking>();
			for(int j=0; j < trackingNew.size(); j++){
				newTrackingList.addAll(compareStatus(trackingNew.get(j),t1.get(i)));
				System.out.println(trackingNew);
			}
			trackingNew.addAll(newTrackingList);

		}

		return trackingNew;
	}
	
	public static void main(String args[]){
		ArrayList<Tracking> t1 = new ArrayList<Tracking>();
		t1.add(new Tracking(1,10,'A',1));
		t1.add(new Tracking(5,15,'B',2));
		t1.add(new Tracking(11,20,'B',1));
		t1.add(new Tracking(17,25,'C',1));
		System.out.println(updateStatus(t1));
	}
}
