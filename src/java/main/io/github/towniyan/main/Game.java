package io.github.towniyan.main;

import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;

public class Game extends GameBase {
	private Text mlocation;
	private Ball ball, ball2;
	private Spaceship spaceship1;

	public Game (GraphicsContext gc) {
		super(gc);
	}

	public void init () {
		this.ball = new Ball(300, 200, 30, 30);
		this.ball.setMoveBlindly(true);
		this.ball.setSpeed(1, -1);

		this.mlocation = new Text("0|0", 20, Settings.HEIGHT - 10);

		// getPlayground().add(this.ball);
		getPlayground().add(this.mlocation);
		getPlayground().add(new Rectangle(0, 0, Settings.WIDTH, 10));
		getPlayground().add(new Rectangle(0, 0, 10, Settings.HEIGHT));
		getPlayground().add(new Rectangle(Settings.WIDTH - 10, 0, 10, Settings.HEIGHT));
		
		spaceship1 = new Spaceship(300, 200);
		getPlayground().add(this.spaceship1);
	}

	public void step () {
		// if (this.ball.getX() > (Settings.WIDTH - 40) ||
		// 	this.ball.getX() < 10)
		// 	this.ball.bounceX();
		// if (this.ball.getY() > (Settings.HEIGHT - 30) ||
		// 	this.ball.getY() < 10)
		// 	this.ball.bounceY();

		// if (this.ball.collidesWith(this.ball2))
		// 	this.ball2.setColor(Color.web("white"));
		// else
		// 	this.ball2.setColor(Color.web("green"));
	}

	public void onKeyPress (KeyCode code) {
		// switch (code) {
		// 	case UP:
		// 		this.spaceship1.push(0, -20);
		// 		break;
		// 	case DOWN:
		// 		this.spaceship1.push(0, 20);
		// 		break;
		// 	case LEFT:
		// 		this.spaceship1.push(-20, 0);
		// 		break;
		// 	case RIGHT:
		// 		this.spaceship1.push(20, 0);
		// 		break;
		// }
	}

	public void onMouseMoved (double x, double y) {
		this.mlocation.setText((int) x + "|" + (int) y);
	}
}