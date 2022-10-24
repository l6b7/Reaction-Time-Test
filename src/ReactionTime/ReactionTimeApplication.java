package ReactionTime;

import ReactionTime.Controller.Controller;
import java.util.LinkedList;
import ReactionTime.Model.ReactionTimeRecordable;
import ReactionTime.Model.ReactionTimeRecorder;
import ReactionTime.Model.StoredTimeRecordable;
import ReactionTime.Model.StoredTimeRecords;
import ReactionTime.View.ApplicationView;

public class ReactionTimeApplication implements Controller {

	private StoredTimeRecordable storedTimeRecords = new StoredTimeRecords();
	private ReactionTimeRecordable r = new ReactionTimeRecorder();
	private final String EMPTY_LAST_RECORD = "--";
	private final String EMPTY_AVERAGE_OF= "--";
	
	public ReactionTimeApplication() {
		new ApplicationView(this);
	}

	public static void main(String[] args) {
		new ReactionTimeApplication();

	}

	@Override
	public LinkedList<Integer> getAllRecords() {
		
		return storedTimeRecords.getAllRecords();
	}

	@Override
	public String getLastRecord() {
		if(storedTimeRecords.getCurrentRecord() == -1) {
			return EMPTY_LAST_RECORD;
		}
		else {
			return Integer.toString(storedTimeRecords.getCurrentRecord());
		}
		
	}

	@Override
	public String getAverageOfRecordsInRange(int range) {
		if(storedTimeRecords.getAverageInRange(range) == -1) {
			return EMPTY_AVERAGE_OF;
		}
		else {
			return Integer.toString(storedTimeRecords.getAverageInRange(range));
		}
	}

	@Override
	public void addRecord(int reactionTimeMS) {
		storedTimeRecords.addRecord(reactionTimeMS);

	}

	@Override
	public int getRandomDelay() {
		return r.getRandomNumber();

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
	public int getRecordsMaxSize(){
		return storedTimeRecords.getRecordsMaxSize();
	}

}
