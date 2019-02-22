package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {

	private final String wordsPath = "data/words";
	
    private Player player;
    private String word;
    private String[] guessed;
    
    public Game() {}

    public Game(String name) {
        player = new Player(name);
        word = "";
    }
    
    public Player getPlayer() {
    	return player;
    }
    
    public void setWord() {
    	StringBuilder buffer = new StringBuilder();
        try {
            File file = new File(wordsPath);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext())  
            	buffer.append(scanner.next());
            scanner.close();  
        } catch (IOException e) { 
            e.printStackTrace();
        }
        String[] words = buffer.toString().split(",");
        int rand = (int)(Math.random() * words.length);
        word = words[rand];
        guessed = new String[word.length()];
        for(int i=0; i<word.length(); i++)
        	guessed[i] = "_";
    }
    
    public String getWord() {
    	return word;
    }
    
    public boolean guess(String w) {
    	if(w.equals("")) return false;
    	w = w.substring(0, 1);
    	boolean res = false;
    	for(int i=0; i<guessed.length; i++) {
    		if(guessed[i].equals("_") && w.equals(word.substring(i, i+1))) {
    			guessed[i] = w;
    			res = true;
    		}
    	}
    	return res;
    }
    
    public String getGuessed() {
    	String res = "";
    	for(int i=0; i<guessed.length; i++)
    		res += guessed[i];
    	return res;
    }
    
    public boolean checkWin() {
    	for(int i=0; i<guessed.length; i++)
    		if(guessed[i].equals("_"))
    			return false;
    	return true;
    }

}

