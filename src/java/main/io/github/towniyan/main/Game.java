package io.github.towniyan.main;

import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import java.util.*;
import io.github.towniyan.objects.*;

public class Game extends GameBase {
	private static Game game;

	private Text mlocation;
	private Ball ball;
	private Rectangle paddle;

	private int times = 0;

	public Game (GraphicsContext gc) {
		super(gc);
	}

	public static void set (Game game) {
		Game.game = game;
	}

	public static Game get () {
		return Game.game;
	}

	public void init () {
		ball = new Ball(300, 200, 10, 10);
		ball.setMoveBlindly(true);
		// ball.setSpeed(5, -5);
		getPlayground().add(ball);

		mlocation = new Text("0|0", 20, Settings.HEIGHT - 10);
		getPlayground().add(mlocation);

		int rectSize = 5;
		getPlayground().add(new Rectangle(0, 0, Settings.WIDTH, rectSize));
		getPlayground().add(new Rectangle(0, 0, rectSize, Settings.HEIGHT));
		getPlayground().add(new Rectangle(Settings.WIDTH - rectSize, 0, rectSize, Settings.HEIGHT));

		paddle = new Rectangle(Settings.WIDTH / 2, Settings.HEIGHT - 50, 100, 20);
		getPlayground().add(paddle);
	}

	public void step () {

	}

	public void onKeyPress (KeyCode code) {
		switch (code) {
			case A:
				times = 0;
				// this.paddle.push(-20, 0);
				Timer t = new Timer();
				TimerTask task = new TimerTask () {
					public void run () {
						if (times <= 100) {
							paddle.push(-1, 0);
							times++;
							t.schedule(task, 10);
						}
					}
				};

				t.schedule(task, 10);
				break;
			case D:
				// this.paddle.push(20, 0);
				for (int i = 0; i < 20; i++) {
					this.paddle.push(1, 0);
				}
				break;
		}
	}

	public void onMouseMoved (double x, double y) {
		this.mlocation.setText((int) x + "|" + (int) y);
		// paddle.place((int) x, paddle.getY());
	}
}