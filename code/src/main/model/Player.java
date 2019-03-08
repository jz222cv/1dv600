package main.model;

public class Player {
	
    private String name;

    public Player(String playerName) {
        name = playerName;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
}

