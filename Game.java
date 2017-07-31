import javafx.scene.canvas.*;
import javafx.scene.input.*;

public class Game extends GameBase {
	private Text mlocation;
	private Ball ball;

	public Game (GraphicsContext gc) {
		super(gc);
	}

	public void init () {
		this.ball = new Ball(300, 200);
		this.ball.setMoveBlindly(true);
		this.ball.setSpeed(1, -1);
		this.mlocation = new Text("0|0", 20, Settings.HEIGHT - 10);

		getPlayground().add(this.ball);
		getPlayground().add(this.mlocation);
		getPlayground().add(new Rectangle(0, 0, Settings.WIDTH, 10));
		getPlayground().add(new Rectangle(0, 0, 10, Settings.HEIGHT));
		getPlayground().add(new Rectangle(Settings.WIDTH - 10, 0, 10, Settings.HEIGHT));
	}

	public void step () {
		render();

		if (this.ball.getX() > (Settings.WIDTH - 40) ||
			this.ball.getX() < 10)
			this.ball.bounceX();
		if (this.ball.getY() > (Settings.HEIGHT - 30) ||
			this.ball.getY() < 10)
			this.ball.bounceY();
	}

	public void onKeyPress (KeyCode code) {
		switch (code) {
			case UP:
				getPlayground().get(0).push(0, -10);
				break;
			case DOWN:
				getPlayground().get(0).push(0, 10);
				break;
			case LEFT:
				getPlayground().get(0).push(-10, 0);
				break;
			case RIGHT:
				getPlayground().get(0).push(10, 0);
				break;
		}
	}

	public void onMouseMoved (double x, double y) {
		this.mlocation.setText((int) x + "|" + (int) y);
		// this.ball.setDestination((int) x, (int) y);
		// this.ball.setSpeed(1, 1);
	}
}