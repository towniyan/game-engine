package io.github.towniyan.threads;

import javafx.animation.*;
import io.github.towniyan.main.*;

public class StepperThread extends Thread {
	private GameBase gb = GameBase.get();

	public void run () {
		new AnimationTimer () {
			public void handle(long now) {
				gb.getGc().clearRect(0, 0, Settings.WIDTH, Settings.HEIGHT);

				for (int i = 0; i < gb.getPlayground().size(); i++) {
					gb.getPlayground().get(i).step();
				}

				gb.step();
			}
		}.start();
	}
}