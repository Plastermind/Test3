package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture grounds;
	Texture gray;
	Texture mage;
	Viewport viewport;
	Camera camera;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("sprites.png");
		gray = new Texture("black.png");
		mage = new Texture("mage.png");
		grounds = new Texture("grounds.png");
		camera= new PerspectiveCamera();
		viewport = new FitViewport(800,400,camera);
		
	}

	int[] moves = { 1, 1, 1, 2, 2, 3, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
	// 6x6 map 6-dirt 7-grass
	int[][] map = {
			{ 6, 6, 6, 7, 6, 6 },
			{ 6, 6, 7, 7, 7, 6 },
			{ 6, 6, 6, 7, 6, 6 },
			{ 6, 6, 6, 7, 6, 6 },
			{ 6, 6, 6, 7, 6, 6 },
			{ 6, 6, 6, 7, 6, 6 } };

	
	// logic
	public void update() {
		if(isLeftArrowPressed()){
			
		}
		if(isRightArrowPressed()){
			
		}
		if(isUpArrowPressed()){
			
		}
		if(isDownArrowPressed()){
			
		}
	}
	@Override
	public void render() {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		// x rises right
		// y rises up
		
		
		
		//print map(ground)
		for(int x=0;x<6;++x){
			for(int y=0;y<6;++y){
				if(map[x][y]==6)
					Draw(x*32,y*32,"dirt");
				if(map[x][y]==7)
					Draw(x*32,y*32,"grass");
			}
		}
		
		// net 32x32
		for (int x = 0; x < 40; ++x) {
			for (int y = 0; y < 40; ++y) {
				Draw(x*32,y*32,"gray",1,100);
				Draw(x*32,y*32,"gray",100,1);		
			}
		}
		batch.end();
	}
	public void Draw(int x, int y, String name){
		Draw(x,y,name,64,64,batch);
	}
	public void Draw(int x, int y, String name, int width, int height){
		Draw(x,y,name,width,height,batch);
	}
	public void Draw(int x, int y, String name, int width, int height, SpriteBatch batch){
		Texture img= this.img;
		int posX=0;
		int posY=0;
		if(name=="mageStatic"){
			img= mage;
			posX= 1 * 64;
			posY= 1 * 64;
		}
		if(name=="dirt"){
			img= grounds;
			width=32;
			height=32;
			posX= 5 * 32;
			posY= 11 * 32;
		}
		if(name=="gray"){
			img= gray;
			posX=0;
			posY=0;
		}
		if(name=="grass"){
			img=grounds;
			width=32;
			height=32;
			posX = 19 * 32;
			posY = 1 * 32;
		}
		batch.draw(img,x,y,posX,posY,width,height);
	}
	
	
	// I don't know that it works
	private boolean isDownArrowPressed() {
		return Gdx.input.isButtonPressed(Input.Keys.DOWN);
	}

	private boolean isUpArrowPressed() {
		return Gdx.input.isButtonPressed(Input.Keys.UP);
	}

	private boolean isRightArrowPressed() {
		return Gdx.input.isButtonPressed(Input.Keys.RIGHT);
	}

	private boolean isLeftArrowPressed() {
		return Gdx.input.isButtonPressed(Input.Keys.LEFT);
	}
	
	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
