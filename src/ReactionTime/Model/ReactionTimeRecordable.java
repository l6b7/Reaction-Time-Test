package ReactionTime.Model;

public interface ReactionTimeRecordable {
	

	
	public int getRandomDelay();
	
	public long getTimestamp();
	
	public int getReactionTime(long startPoint, long endPoint);
	
}
