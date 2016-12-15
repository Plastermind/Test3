package com.mygdx.game.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 400;
		config.title = "Tibia";
		int fps = 3;
		config.backgroundFPS = fps;
		config.foregroundFPS = fps;
		config.addIcon("tibia.jpg", FileType.Internal);
		// System.out.println(System.getProperty("user.dir"));

		new LwjglApplication(new MyGdxGame(), config);
		// Gitara Siema ;-D
	}
}
