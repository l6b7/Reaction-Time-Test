package ReactionTime.Controller;

public interface Controller {
	public int[] updateResults();
	public void clearLastResult();
	public void clearResults();
	public int getRandomDelay();
	public void getDelay();
	public void addRecord(int reactionTimeMS);
	public int getReactionTime(long startPoint, long endPoint);	
}
