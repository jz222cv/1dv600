package main.view;

import java.util.Scanner;

public class View {
	
    private Scanner scanner;

    public int getInt() {
    	scanner = new Scanner(System.in);
    	int input = -1;
    	try {
    		input = scanner.nextInt();
    	}catch(Exception e) {
    		System.out.println("Please input an positive integer.");
    		input = getInt();
    	}
        return input;
    }

    public String getString() {
    	scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void displayStart() {
        System.out.println("Welcome to HANGMAN");
        System.out.println("1. New game");
        System.out.println("2. Load game");
        System.out.println("3. Quit");
    }
    
    public void displayLoadGameSuccessfully() {
    	System.out.println("Load the game successfully.");
    }
    
    public void displayLoadGameFailed() {
    	System.out.println("Load the game failed.");
    }

    public void displayPlay() {
        System.out.println("Please guess one word:");
    }

    public void displayInputName() {
        System.out.println("Please input name: ");
    }

    public void displayGuess(int turn, int max, String guessed) {
        System.out.println("Life: " + turn + " / " + max);
        System.out.println("Word:" + guessed);
    }
    
    public void displayFail(String word) {
    	System.out.println("You lose the game...\nThe word is \"" + word + "\"");
    }
    
    public void displaySucceed() {
    	System.out.println("Congratulations! You win the game!\n");
    }
    
    public void displayQuit() {
    	System.out.println("You have quit the game.");
    }

}
