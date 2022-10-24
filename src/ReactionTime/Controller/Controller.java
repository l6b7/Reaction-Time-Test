package ReactionTime.Controller;

import java.util.LinkedList;

public interface Controller {
	
	public LinkedList<Integer> getAllRecords();
	
	public int[] updateResults();

	public void clearLastResult();

	public void clearResults();

	public int getRandomDelay();

	public void addRecord(int reactionTimeMS);

	public int getReactionTime(long startPoint, long endPoint);
}
