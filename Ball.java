import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Ball extends GameObject {
	public Ball (int x, int y) {
		super(x, y);
	}

	public void step (GraphicsContext gc) {
		if (super.getMoveBlindly())
			moveBlindly();
		else
			move();

		gc.setFill(Color.web("orange"));
		gc.fillOval(getX(), getY(), 30, 30);
	}
}