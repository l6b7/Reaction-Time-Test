package ReactionTime;

import java.util.Scanner;

public class ReactionTimeRecorder {
		


	public int testReactionTime() {
		Scanner consoleInput = new Scanner(System.in);
		String userAction;

		printGameRules();
		userAction = consoleInput.next();

		getRandomDelay(Math.random());

		long start = System.nanoTime();

		userAction = consoleInput.next();

		long finish = System.nanoTime();

		long timeElapsed = (finish - start);
		consoleInput.close();

		return (int) (timeElapsed / 1000000);
		
		
		
	}

	private static void printGameRules() {
		System.out.println("Enter anything into console to start");
		System.out.println("you have a random amount of time before pop appears");
		System.out.println("get your character in the console ready to enter to measure ur reaction speed");
	}

	private static void getRandomDelay(double randomNumber) {
		try {
			Thread.sleep(2000 + (int) (randomNumber * 1234));
			System.out.println("POP");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}

}
