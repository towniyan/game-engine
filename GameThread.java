import javafx.scene.canvas.*;

public class GameThread extends Thread {
	private GraphicsContext gc;

	public GameThread(GraphicsContext gc) {
		this.gc = gc;
	}

	public void run () {
		new Game(gc);
	}
}