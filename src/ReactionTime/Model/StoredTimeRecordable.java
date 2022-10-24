package ReactionTime.Model;

import java.util.LinkedList;

public interface StoredTimeRecordable  {
	
	public void addRecord(int ReactionTimeMS);
	
	public void removeAllRecords();
	
	public LinkedList<Integer> getAllRecords();
	
	public void removeLastRecord();
	
	public int getCurrentRecord();
	
	public int getAverageInRange(int Range);
}
