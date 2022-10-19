package ReactionTime;

import ReactionTime.Controller.Controller;
import ReactionTime.Model.ReactionTimeRecordable;
import ReactionTime.Model.ReactionTimeRecorder;
import ReactionTime.Model.StoredTimeRecordable;
import ReactionTime.Model.StoredTimeRecords;
import ReactionTime.View.ApplicationView;

public class ReactionTimeApplication implements Controller {
	
	private StoredTimeRecordable tr = new StoredTimeRecords();
	private ReactionTimeRecordable r = new ReactionTimeRecorder();
	
	private ApplicationView view;
	
	
	
	public ReactionTimeApplication() {
		view = new ApplicationView(this);
	}
	
	
	public static void main(String[] args) {
		new ReactionTimeApplication();

	}

	@Override
	public int[] updateResults() {
		int current = tr.getCurrentRecord();
		int avgOf3  = tr.getAverageInRange(3);
		int avgOf5  = tr.getAverageInRange(5);
		int avgOf10 = tr.getAverageInRange(10);
		
		return new int[] {current,avgOf3,avgOf5,avgOf10};
		
	}

	@Override
	public void clearResults() {
		tr.removeAllRecords();
		
	}

	//boolean faulstart()
	
	@Override
	public void addRecord(int reactionTimeMS) {
		tr.addRecord(reactionTimeMS);
		
	}

	@Override
	public void getReactionTime(long startPoint, long endPoint) {
		r.getReactionTime(startPoint, endPoint);
		
	}

}
