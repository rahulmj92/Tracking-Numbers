public class TravelTable {
	
	int rangeStartValue;
	int rangeEndValue;
	char statusCode;
	int transferCode;
	
	TravelTable(){
		this.rangeStartValue =  0;
		this.rangeEndValue =  1000000;
		this.statusCode = 'A';
		this.transferCode = 1;
	}
	
	TravelTable(int rangeStartValue, int rangeEndValue, char statusCode, int transferCode) {
		this.rangeStartValue =  rangeStartValue;
		this.rangeEndValue =  rangeEndValue;
		this.statusCode = statusCode;
		this.transferCode = transferCode;
	}
}
