package com.mygdx.game;

public class Character{
	int x,y;
	int hp;
	int hpMax;
	int mana;
	int manaMax;
	int lvl;
	boolean moving;
	int state;
	World world;
	Category category;
	/*
	 * 		1
	 * 	4		2
	 * 		3
	 */
	public int move(int dir){
		int xp=x;
		int yp=y;
		// xp - x'
		// yp - y'
		if(dir==1){
			yp+=1;
		}
		if(dir==2){
			xp+=1;
		}
		if(dir==3){
			yp-=1;
		}
		if(dir==4){
			xp-=1;
		}
		if(world.canMove(xp, yp, this)){
			world.unlock(x,y);
			world.place(xp, yp, this);
			moving=true;
			return 1;
		}
		else{
			return 0;
		}
	}
	public int take(){return 0;}
	public int msg(){return 0;}
	public Character(int x, int y,int hpMax, int manaMax, World world, Category category){
		if(world.canMove(x,y,this)){
			world.place(x,y,this);
			this.x=x;
			this.y=y;
			this.hpMax = this.hp = hpMax;
			this.manaMax = this.mana = manaMax;
			this.world=world;
			this.category=category;
		}
		else{
			// exception
		}
	}
	private void updateFrame(){
		if(moving){
			if(state==0){
				state=4;
			}
			else if(state==4) state=8;
			else state=4;
		}
		else state=0;
	}
	/*
	 * Category - klasa np. wojownik
	 */
}
