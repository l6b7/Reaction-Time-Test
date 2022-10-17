package ReactionTime;

public class main {

	public static void main(String[] args) {
		ReactionTimeRecords tr = new ReactionTimeRecords();
		ReactionTimeRecorder r = new ReactionTimeRecorder();
		
		System.out.println("/// Controler Class prints all records using TimesRecorded class");
		tr.getAllRecords();
		System.out.println("/// Controler class adds a record using TimesRecorded class "
				+"\n"+ "but first it creates a record using ReactionTimeRecorderclass class ");
		tr.addRecord(r.testReactionTime());
		System.out.println("/// Controler Class prints all records using TimesRecorded class");
		tr.getAllRecords();

	}

}
