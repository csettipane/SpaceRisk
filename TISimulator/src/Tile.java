import java.util.ArrayList;
import java.util.HashMap;

import units.Unit;
public class Tile {
	// arraylist or map?
	private ArrayList<Planet> planets;
	private Player controller;
	private boolean[] hasPlayerToken;
	private int capacity;
	private int xCoord;
	private int yCoord;
	// private 	private ArrayList<System> adjacentSystems??; 
	// NOTE WE ARE IMPLEMENTING MAP HAS UNITS
	Tile(){
	}
	
	public void setController(Player player){
		this.controller = player;
	}
	
	public Player getController() {
		return controller;
	}

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public boolean[] getHasPlayerToken() {
		return hasPlayerToken;
	}

	public void setHasPlayerToken(int playerID, boolean hasPlayerToken) {
		this.hasPlayerToken[playerID] = hasPlayerToken;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
