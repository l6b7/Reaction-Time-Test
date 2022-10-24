package ReactionTime.Model;

public class ReactionTimeRecorder implements ReactionTimeRecordable {

	@Override
	public int getRandomNumber() { 
		// for the random delay in milliseconds purpose it should give
		// 500ms base plus 0 to 3000 milliseconds or from 0,5sec to 3,5 seconds
		return 500 + (int) (Math.random() * 3000);
	}
}