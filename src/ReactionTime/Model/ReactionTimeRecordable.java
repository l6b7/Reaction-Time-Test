package ReactionTime.Model;

public interface ReactionTimeRecordable {

	public int getRandomNumber();
	
	public int getReactionTime(long startPoint, long endPoint);
}
