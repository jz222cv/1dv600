package main.controller;

import main.model.Game;
import main.view.View;

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
            	fail = 0;
                game = new Game(name);
                playGame(game);
                break;
            // Load game
            case 2: 
            	String[] load = game.load();
            	if(load.length!=5) {
            		view.displayLoadGameFailed();
            		start();
            	} else {
            		game.setPlayer(load[0]);
                	game.setWord(load[1]);
                	game.setGuessed(load[2]);
                	turn = Integer.parseInt(load[3]);
                	fail = Integer.parseInt(load[4]);
                	view.displayLoadGameSuccessfully();
                	view.displayGuess(fail, max, game.getGuessed());
                	playGame(game);
            	}
            	break;
            // Quit
            case 3: 
            	view.displayQuit();
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
        	game.delete();
        	view.displayFail(game.getWord());
        	start();
        } else {
        	view.displayGuess(fail, max, game.getGuessed());
        	if(game.checkWin()) {	// succeed
        		game.delete();
        		view.displaySucceed();
        		start();
        	}else {
        		game.save(game.getPlayer().getName(), game.getWord(), game.getGuessed(), turn, fail);
        		playGame(game);
        	}
        }
    }

  
}
