package main.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Game {

	private final String wordsPath = "data/words";
	private final String loadPath = "data/load";
	
    private Player player;
    private String word;
    private String[] guessed;
    
    public Game() {}

    public Game(String name) {
        player = new Player(name);
        word = "";
    }
    
    public void setPlayer(String name) {
    	player.setName(name);
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
    
    public void setWord(String word) {
    	this.word = word;
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
    
    public void setGuessed(String word) {
    	guessed = new String[word.length()];
        for(int i=0; i<word.length(); i++)
        	guessed[i] = word.substring(i, i+1);
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
    
    public void save(String playerName, String word, String guessed, int turn, int fail) {
    	String data = playerName + "," + word + "," + guessed + "," + turn + "," + fail;
    	FileOutputStream fos = null;
		File file = new File(loadPath);
		try {
			fos = new FileOutputStream(file);
			fos.write(data.getBytes());
			fos.flush();
		} catch (IOException e) {
			System.err.println("No File");
		}finally{
			if (fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.err.println("Close File Failed");
				}
			}
		}
    }
    
    public String[] load() {
		File json = new File(loadPath);
		String str = "";
		try {
			Scanner sc = new Scanner(json);
			while(sc.hasNextLine()) {
				str += sc.nextLine();
			}
			sc.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(str.length()==0) return null;
		return str.split(",");
    }
    
    public void delete() {
    	String data = "";
    	FileOutputStream fos = null;
		File file = new File(loadPath);
		try {
			fos = new FileOutputStream(file);
			fos.write(data.getBytes());
			fos.flush();
		} catch (IOException e) {
			System.err.println("No File");
		}finally{
			if (fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.err.println("Close File Failed");
				}
			}
		}
    }

}

