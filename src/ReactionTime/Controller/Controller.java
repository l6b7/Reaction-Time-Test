package ReactionTime.Controller;

public interface Controller {
	public int[] updateResults();
	public void clearResults();
	public void addRecord(int reactionTimeMS);
	public void getReactionTime(long startPoint, long endPoint);	
}
