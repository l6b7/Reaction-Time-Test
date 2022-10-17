package ReactionTime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class StoredTimeRecords implements StoredTimeRecordable {

	private int recordsMaxSize = 20;
	private LinkedList<Integer> records;
	private String filepath = "test.txt";

	StoredTimeRecords() {
		records = readRecordsFromAFile();
	}

	@Override
	public void addRecord(int ReactionTimeMS) {

		if (records.size() > recordsMaxSize) {
			records.removeLast();
			records.addFirst(ReactionTimeMS);
		} else {
			records.addFirst(ReactionTimeMS);
		}

		saveRecordsToAFile(records);
		
	}

	@Override
	public void getAllRecords() {
		System.out.println("idk what to retun yet so I print record list");
		System.out.println(records);
	}

	@Override
	public void removeAllRecords() {
		records = new LinkedList<Integer>();
		saveRecordsToAFile(records);
		
	}

	@Override
	public int getCurrentRecord() {
		return records.get(0);
		
	}
	
	@Override
	public int getAverageInRange(int range) {
		int averageInRange = 0;

		if (records.isEmpty()) {
			return averageInRange;
		} else if (records.size() < range) {
			for (int i = 0; i < records.size(); i++) {
				averageInRange += records.get(i);
			}
			return averageInRange / records.size();
		} else {
			for (int i = 0; i < range; i++) {
				averageInRange += records.get(i);
			}
			return averageInRange / records.size();
		}
	}

	
	private void saveRecordsToAFile(LinkedList<Integer> records) {
		try (FileWriter fileWriter = new FileWriter(filepath); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			boolean FirstElement = true;
			for (Integer record : records) {
				if (FirstElement) {
					bufferedWriter.write(Integer.toString(record));
					FirstElement = false;
				} else {
					bufferedWriter.write("\n" + Integer.toString(record));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private LinkedList<Integer> readRecordsFromAFile() {

		Path path = Paths.get(filepath);
		if (Files.exists(path)) {

			try (FileReader fileReader = new FileReader(filepath); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

				LinkedList<Integer> records = new LinkedList<Integer>();

				String textLine;
				while ((textLine = bufferedReader.readLine()) != null) {
					if (records.size() > recordsMaxSize) {
						return new LinkedList<Integer>();
					}
					records.addLast(Integer.parseInt(textLine));
				}
				return records;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			return new LinkedList<Integer>();

		
	}

}
