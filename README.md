Tracking-Numbers
================

Range Class :

  Data Members:
  ->int startRange
  ->int endRange

  Functionalities to be implemented are:
  -> boolean DoesRangeOverLap(TrackingNumberRange range)
  -> ArrayList<TrackingNumberRange> SplitRanges(TrackingNumberRange range)
  -> TrackingNumberRange MergeRanges(TrackingNumberRange range)
  -> TrackingNumberRange FindNextRange(TrackingNumberRange range)
  
  
TrackingNumber Class :

  Data Members :
  -> Range range
  -> char statusCode
  -> int transferCode
  
  Functionalities :
  -> compareRanges(TrackingNumber, TrackingNumber)
  -> finalizeRange(TrackingNumber)
  
  
  

  
