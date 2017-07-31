import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Rectangle extends GameObject {
	private int x, y, width, height;

	public Rectangle (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void step (GraphicsContext gc) {
		gc.setFill(Color.web("yellow"));
		gc.fillRect(this.x, this.y, this.width, this.height);
	}
}