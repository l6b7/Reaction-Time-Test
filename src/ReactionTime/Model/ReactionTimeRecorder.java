package ReactionTime.Model;

public class ReactionTimeRecorder implements ReactionTimeRecordable {

	@Override
	public int getRandomNumber() {
		return 500 + (int) (Math.random() * 3000);
	}

	@Override
	public int getReactionTime(long startPoint, long endPoint) {
		return (int) (endPoint - startPoint) / 1000000;
	}
}
