package view;

import java.util.Scanner;

public class View {
	
    private Scanner scanner = new Scanner(System.in);

    public int getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.next();
    }

    public void displayStart() {
        System.out.println("Welcome to HANGMAN");
        System.out.println("1. New game");
        System.out.println("2. Quit");
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
    
    public void displayFail() {
    	System.out.println("You lose the game...\n");
    }
    
    public void displaySucceed() {
    	System.out.println("Congratulations! You win the game!\n");
    }

}
