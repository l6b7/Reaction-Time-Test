package ReactionTime.Model;

import java.util.Scanner;

public class ReactionTimeRecorder implements ReactionTimeRecordable {
		


	public int testReactionTime() {
		Scanner consoleInput = new Scanner(System.in);
		String userAction;

		System.out.println("enter anything in the console to start"+ "\n"
							+ "once you see pop"+ "\n"
							+ "enter anything in the console to get your reaction time");
		
		userAction = consoleInput.next();

		getRandomDelay();
		
		System.out.println("pop");
		
		long startPoint = getTimestamp();

		userAction = consoleInput.next();

		long endPoint = getTimestamp();
		
		return getReactionTime(startPoint, endPoint);
	
	}


	


	@Override
	public long getTimestamp() {
		return System.nanoTime();
	}

	@Override
	public int getReactionTime(long startPoint, long endPoint) {
		return (int) (endPoint - startPoint) / 1000000;
	}

	

	
	@Override
	public int getRandomDelay() {
		return (int)(Math.random() * 1000);
		
	}

}
