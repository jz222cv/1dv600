package controller;

import model.Game;
import view.View;

public class Play {
	
    private View view = new View();
    private Game game = new Game("");
    private int turn = 0;
    private int fail = 0;
    
    private final int max = 8;
    
    public void start() {
        view.displayStart();
        switch (view.getInt()) {
        	// Start a new game
            case 1: 
            	view.displayInputName();
            	String name = view.getString();
            	turn = 0;
                game = new Game(name);
                playGame(game);
                break;
            // Quit
            case 2: 
            	break;
            default: 
            	start();
            	break;
        }
    }

    public void playGame(Game game) {
        if(turn==0) game.setWord();
        view.displayPlay();
        String guess = view.getString();
        boolean res = game.guess(guess);
        turn ++;
        if(!res) fail ++;
        if(fail==max) {	// fail
        	view.displayFail();
        	start();
        } else {
        	view.displayGuess(fail, max, game.getGuessed());
        	if(game.checkWin()) {	// succeed
        		view.displaySucceed();
        		start();
        	}else {
        		playGame(game);
        	}
        }
    }

  
}
