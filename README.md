Tracking-Numbers
================

Range Class :

  Data Members:
  ->int startRange
  ->int endRange

  Functionalities to be implemented are:
  -> boolean DoesRangeOverLap(TrackingNumberRange range)
  -> boolean doesRangeLieInsideAnother(Range list)
  -> ArrayList<TrackingNumberRange> SplitRanges(TrackingNumberRange range)
  -> TrackingNumberRange MergeRanges(TrackingNumberRange range)
  
  
TrackingNumber Class :

  Data Members :
  -> Range range
  -> char statusCode
  -> int transferCode
  
  Functionalities :
  -> compareRanges(TrackingNumber, TrackingNumber)
  
  -> finalizeRange(TrackingNumber)
  
  -> updateRange(TrackingNumber[])
  
  
  

  
