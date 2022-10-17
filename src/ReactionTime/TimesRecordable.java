package ReactionTime;

public interface TimesRecordable  {
	
	
	
	
	public void addRecord(int ReactionTimeMS);
	
	public void removeAllRecords();
	
	public void getAllRecords();
	
	public int getCurrentRecord();
	
	public int getAverageInRange(int Range);
	
}
