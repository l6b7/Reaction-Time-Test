package ReactionTime;

public interface ReactionTimeRecordable {
	
	public void getRandomDelay();
	
	public void getRandomDelay(int minimumDelay);
	
	public long getTimestamp();
	
	public int getReactionTime(long startPoint, long endPoint);
	
}
