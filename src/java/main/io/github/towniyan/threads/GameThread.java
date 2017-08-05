package io.github.towniyan.threads;

import javafx.scene.canvas.*;
import io.github.towniyan.main.*;

public class GameThread extends Thread {
	private GraphicsContext gc;

	public GameThread(GraphicsContext gc) {
		this.gc = gc;
	}

	public void run () {
		new Game(gc);
	}
}