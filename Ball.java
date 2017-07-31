import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Ball extends GameObject {
	private Color color = Color.web("orange");

	public Ball (int x, int y) {
		super(x, y);
	}

	public void step (GraphicsContext gc) {
		if (super.getMoveBlindly())
			moveBlindly();
		else
			move();

		gc.setFill(this.color);
		gc.fillOval(getX(), getY(), 30, 30);
	}

	public void setColor (Color color) {
		this.color = color;
	}
}