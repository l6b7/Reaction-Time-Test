package ReactionTime;

import java.util.Scanner;

public class ReactionTimeRecorder implements ReactionTimeRecordable {
		
	public static void main(String[] args) {
		ReactionTimeRecorder r = new ReactionTimeRecorder();
	}

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

	
	@Override // more random but a possibility of not noticeable delay
	public void getRandomDelay() {
		try {
			Thread.sleep(100 + (int)((Math.random() * 1000) * 2 ));
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
		
	}
	
	@Override
	public void getRandomDelay(int minimumDelay) {
		try {
			Thread.sleep(minimumDelay + (int)(Math.random() * 1000));
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
		
	}

}
