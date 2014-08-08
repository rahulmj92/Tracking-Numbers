public class TrackingTable extends Range{
	
	Range range;
	char statusCode;
	int transferCode;
	
	TravelTable(){
		range = new Range(0, 1000000);
		this.statusCode = 'A';
		this.transferCode = 1;
	}
	
	TravelTable(int rangeStartValue, int rangeEndValue, char statusCode, int transferCode) {
		range = new Range(rangeStartValue, rangeEndValue);
		this.statusCode = statusCode;
		this.transferCode = transferCode;
	}
