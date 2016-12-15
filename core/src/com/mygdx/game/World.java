package com.mygdx.game;

import java.util.ArrayList;

public class World {
	String name;
	Character [][] map;
	ArrayList <Character> guysMoving;
	public Character get(int x, int y){		
		return map[x][y];
	}
	public World(int x, int y){
		map=new Character[x][y]; 
	}
	public void AddGuyToGuysMoving(Character character){
		guysMoving.add(character);
	}
	
	public boolean canMove(int x, int y, Character character) {
		return this.get(x,y)==null;
	}
	public void place(int x, int y, Character character) {
		map[x][y]=character;
	}
	public void unlock(int x, int y) {
		map[x][y]=null;
	}
	
	
}
