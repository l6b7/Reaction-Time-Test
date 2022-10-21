package ReactionTime;

import ReactionTime.Controller.Controller;
import ReactionTime.Model.ReactionTimeRecordable;
import ReactionTime.Model.ReactionTimeRecorder;
import ReactionTime.Model.StoredTimeRecordable;
import ReactionTime.Model.StoredTimeRecords;
import ReactionTime.View.ApplicationView;

public class ReactionTimeApplication implements Controller {
	
	private StoredTimeRecordable storedTimeRecords = new StoredTimeRecords();
	private ReactionTimeRecordable r = new ReactionTimeRecorder();
	
	private ApplicationView view;
	
	
	
	public ReactionTimeApplication() {
		//view = new ApplicationView(this);
	}
	
	
	public static void main(String[] args) {
		new ReactionTimeApplication();

	}

	@Override
	public int[] updateResults() {
		int current = storedTimeRecords.getCurrentRecord();
		int avgOf3  = storedTimeRecords.getAverageInRange(3);
		int avgOf5  = storedTimeRecords.getAverageInRange(5);
		int avgOf10 = storedTimeRecords.getAverageInRange(10);
		
		return new int[] {current,avgOf3,avgOf5,avgOf10};
		
	}

	@Override
	public void clearResults() {
		storedTimeRecords.removeAllRecords();
		
	}

	@Override
	public void clearLastResult() {
		storedTimeRecords.removeLastRecord();
	}
	

	@Override
	public void addRecord(int reactionTimeMS) {
		storedTimeRecords.addRecord(reactionTimeMS);
		
	}

	@Override
	public int getReactionTime(long startPoint, long endPoint) {
		return r.getReactionTime(startPoint, endPoint);
	}

	@Override
	public int getRandomDelay() {
		return 500 + r.getRandomDelay() * 3;
		
	}
	
	
	@Override
	public void getDelay() {
		
	}





}
