package ReactionTime.Model;

public interface StoredTimeRecordable  {
	
	
	
	
	public void addRecord(int ReactionTimeMS);
	
	public void removeAllRecords();
	
	public void getAllRecords();
	
	public void removeLastRecord();
	
	public int getCurrentRecord();
	
	public int getAverageInRange(int Range);
	
}
